/******************************************************************************
 * Product: ADempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 2006-2017 ADempiere Foundation, All Rights Reserved.         *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * or (at your option) any later version.                                     *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * or via info@adempiere.net                                                  *
 * or https://github.com/adempiere/adempiere/blob/develop/license.html        *
 *****************************************************************************/

package org.spin.hr.engine;

import java.util.*;
import org.spin.model.*;
import org.adempiere.model.*;
import org.spin.util.*;
import org.compiere.util.*;
import org.eevolution.model.*;
import org.spin.hr.util.RuleInterface;
import org.eevolution.hr.model.*;
import java.math.*;
import java.sql.*;



/** Generated Process for (groovy:R_ColacionImponible R_ColacionImponible)
 *  @author ADempiere (generated) 
 *  @version Release 3.9.4
 */
public class groovy_R_ComisionFija implements RuleInterface {

	String description = null;

	@Override
	public Object run(MHRProcess process, Map<String, Object> engineContext) {


		double result = 0;
		description = null;

		Double comision = process.getConcept("P_ComisionFifa");
		int daysNet = process.getHR_Payroll().getHR_Contract().getNetDays();
		double diasAusentes = process.getConcept("O_DiasAusentes");
		double colacionDiaria = comision/daysNet; 					
		double ded1 = diasAusentes*colacionDiaria;
		return comision - ded1;
	}

	@Override
	public String getDescription() {
		return description;
	}
}