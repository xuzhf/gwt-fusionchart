/**
 * Copyright (c) 2008 Raise Partner
 * 22, av. Doyen Louis Weil,
 * 38000 Grenoble, France
 * All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * Contact: sebastien@chassande.fr
 */
package com.raisepartner.chartfusion.generator;

import java.io.PrintStream;

public class Logger {

    public static PrintStream out = null;

    public static boolean debug = true;
    public static boolean info = true;
    public static void debug(String message) {
        if (debug && out != null) {
            out.println("DEBUG: " + message);
        }
    }
    public static void info(String message) {
        if (info) {
            System.out.println("INFO:  " + message);
            if (out != null) {
                out.println("INFO:  " + message);
            }
        }
    }
    public static void warn(String message) {
        System.err.println("WARN:  " + message);
        if (out != null) {
            out.println("WARN:  " + message);
        }
    }
    public static void error(String message) {
        System.err.println("ERROR: " + message);
        if (out != null) {
            out.println("ERROR: " + message);
        }
    }


}
