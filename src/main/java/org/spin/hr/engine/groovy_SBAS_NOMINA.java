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

import org.spin.hr.util.RuleInterface;
import org.spin.model.*;
import org.adempiere.model.*;
import org.spin.util.*;
import org.compiere.util.*;
import org.eevolution.hr.model.*;
import org.compiere.model.*;
import java.math.*;
import java.sql.*;



/** Generated Process for (groovy:SBAS_NOMINA Sueldo básico de Nomina General)
 *  Help: Base para calcular gratificacion
 *  @author ADempiere (generated) 
 *  @version Release 3.9.4
 */
public class groovy_SBAS_NOMINA implements RuleInterface {

	String description = null;

	@Override
	public Object run(MHRProcess process, Map<String, Object> engineContext) {
		
		double result = 0;
		description = null;
		double salarioActual = process.getConcept("R_SBAS") +  process.getConcept("R_BonifiacionFija"); 
		double salarioDiario = process.getConcept("R_SBAS_DAY");
		double diasAusentes = process.getConcept("O_DiasAusentes");
		double ded1 = diasAusentes*salarioDiario;
		
		double total = salarioActual - ded1 ;
		
		result = total ;
		return result;
	}

	@Override
	public String getDescription() {
		return description;
	}
}