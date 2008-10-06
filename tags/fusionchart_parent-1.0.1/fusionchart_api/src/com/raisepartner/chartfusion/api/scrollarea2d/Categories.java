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
package com.raisepartner.chartfusion.api.scrollarea2d;

public class Categories extends com.raisepartner.chartfusion.api.Categories {


	public Categories() {
	}
        /**
         * @see com.raisepartner.chartfusion.api.scrollarea2d.Category
         */
        public Category createCategoryNode() {
                Category node = new Category();
		addNode(node);
		return node;
        }

        /**
         * @see com.raisepartner.chartfusion.api.scrollarea2d.VLine
         */
        public VLine createVLineNode() {
                VLine node = new VLine();
		addNode(node);
		return node;
        }

}
