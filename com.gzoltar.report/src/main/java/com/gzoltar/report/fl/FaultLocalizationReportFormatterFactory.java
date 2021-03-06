/**
 * Copyright (C) 2020 GZoltar contributors.
 * 
 * This file is part of GZoltar.
 * 
 * GZoltar is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * 
 * GZoltar is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along with GZoltar. If
 * not, see <https://www.gnu.org/licenses/>.
 */
package com.gzoltar.report.fl;

import com.gzoltar.report.IReportFormatter;
import com.gzoltar.report.ReportFormatter;
import com.gzoltar.report.fl.config.ConfigHTMLReportFormatter;
import com.gzoltar.report.fl.config.ConfigTxtReportFormatter;

/**
 * FaultLocalizationReportFormatterFactory class.
 */
public abstract class FaultLocalizationReportFormatterFactory {

  public static IReportFormatter createReportFormatter(final ReportFormatter formatter) {
    switch (formatter) {
      case TXT:
      default:
        return new ConfigTxtReportFormatter();
      case HTML:
        return new ConfigHTMLReportFormatter();
    }
  }
}
