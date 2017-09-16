package com.gzoltar.report;

import java.util.List;
import com.gzoltar.core.model.Node;
import com.gzoltar.core.spectrum.FilteredSpectrumBuilder;
import com.gzoltar.core.spectrum.ISpectrum;

public class FilteredReport extends AbstractReport {

  private final FilteredSpectrumBuilder fsb = new FilteredSpectrumBuilder();
  private final Node node;
  private ISpectrum generatedSpectrum;

  public FilteredReport(ISpectrum spectrum, String granularity, Node node) {
    super(spectrum, granularity);
    this.node = node;

    fsb.setSource(spectrum).includeNode(node);
  }

  @Override
  protected ISpectrum getSpectrum() {
    if (generatedSpectrum == null) {
      generatedSpectrum = fsb.getSpectrum();
    }
    return generatedSpectrum;
  }

  @Override
  protected void addDescription(List<String> scores) {
    scores.add("Metric scores for node " + this.getName() + ":");
  }

  @Override
  public String getName() {
    return node.getFullName();
  }

}
