<?xml version="1.0" encoding="UTF-8"?>
<!--Designed and generated by Altova StyleVision Enterprise Edition 2011 sp1 - see http://www.altova.com/stylevision for more information.-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:clitype="clitype" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:iso4217="http://www.xbrl.org/2003/iso4217" xmlns:ix="http://www.xbrl.org/2008/inlineXBRL" xmlns:java="java" xmlns:link="http://www.xbrl.org/2003/linkbase" xmlns:xbrldi="http://xbrl.org/2006/xbrldi" xmlns:xbrli="http://www.xbrl.org/2003/instance" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:altova="http://www.altova.com" exclude-result-prefixes="clitype fn iso4217 ix java link xbrldi xbrli xlink xs xsi altova">
	<xsl:output version="4.0" method="html" indent="no" encoding="UTF-8" doctype-public="-//W3C//DTD HTML 4.01 Transitional//EN" doctype-system="http://www.w3.org/TR/html4/loose.dtd"/>
	<xsl:param name="SV_OutputFormat" select="'HTML'"/>
	<xsl:param name="USER"/>
	<xsl:variable name="bookingHeader" select="/com.kcdata.abe.business.response.BreakdownChargesResponse/bookingHeader"/>
	<xsl:variable name="breakdownChargesHeader" select="/com.kcdata.abe.business.response.BreakdownChargesResponse/breakdownChargesHeader"/>
	<xsl:variable name="guestBreakdownCharge" select="/com.kcdata.abe.business.response.BreakdownChargesResponse/breakdownCharges/com.kcdata.abe.data.dto.GuestBreakdownCharge"/>
	<xsl:variable name="guestBreakdownCommissionCharge" select="/com.kcdata.abe.business.response.BreakdownChargesResponse/commissionCharges/com.kcdata.abe.data.dto.GuestBreakdownCommissionCharge"/>
	<xsl:variable name="guestInfo" select="/com.kcdata.abe.business.response.BreakdownChargesResponse/guests/object-array/com.kcdata.abe.data.dto.GuestInfo"/>
	<xsl:variable name="applicationInfo" select="/com.kcdata.abe.business.response.BreakdownChargesResponse/applicationInfo"/>
	<xsl:template match="/">
		<html>
			<head>
				<title>
					<xsl:text> </xsl:text>
				</title>
				<meta http-equiv="X-UA-Compatible" content="IE=7"/>
				<style type="text/css">
				.LABEL.largerheading { color:#000000;
				font-family:arial;
				font-size:13px;
				font-weight:bold;
				 }
				.internalusenotice { color:#FF0000;
				font-family:arial;
				font-size:11px;
				font-weight:bold;
				 } 
				.hidden { color:#000000;
				font-family:arial;
				font-size:15px;
				font-weight:bold;
				 } 
				.innergrids { border-bottom:#bdb09c 1px solid;
				border-left:#bdb09c 1px solid;
				border-right:#bdb09c 1px solid;
				border-top:#bdb09c 1px solid;
				horizontal-align:center;
				horizontal-gap:0;
				padding-bottom:6px;
				padding-left:4px;
				padding-right:4px;
				padding-top:6px;
				vertical-align:middle;
				vertical-gap:0;
				 }
				.headergrids { background:#fffaf3;
				border-bottom:#bdb09c 1px solid;
				border-left:#bdb09c 1px solid;
				border-radius:8px;
				border-right:#bdb09c 1px solid;
				border-top:#bdb09c 1px solid;
				horizontal-align:center;
				horizontal-gap:0;
				padding-bottom:6px;
				padding-left:4px;
				padding-right:4px;
				padding-top:6px;
				vertical-align:middle;
				vertical-gap:0;
				 }
				.labelSmallHeading { color:#000000;
				disabledcolor:#000000;
				font-family:arial;
				font-size:11px;
				font-weight:bold;
				 }
				.labelnoHeading { color:#000000;
				disabledcolor:#000000;
				font-family:arial;
				font-size:11px;
				 }
				.itineraryPriceChargesGrid { background:#ffffff;
				border-bottom:#bdb29c 1px solid;
				border-left:#bdb29c 1px solid;
				border-right:#bdb29c 1px solid;
				border-top:#bdb29c 1px solid;
				cellpadding:0;
				cellspacing:0;
				font-family:arial;
				font-size:10px;
				horizontalgap:0;
				paddingbottom:2;
				paddingleft:2;
				paddingright:2;
				paddingtop:2;
				verticalgap:0;
				 }
				.itineraryPriceChargesHeader { background-color:#decfb5;
				border-bottom:#bdb29c 1px solid;
				border-left:#bdb29c 1px solid;
				border-right:#bdb29c 1px solid;
				border-sides:right bottom;
				border-top:#bdb29c 1px solid;
				font-family:arial;
				font-size:10px;
				font-weight:bold;
				text-align:left;
				vertical-align:middle;
				 }
				.labelwithborder { border-bottom:1px solid;
				border-left-style:solid;
				border-right-style:solid;
				border-top:1px solid;
				 }
				.tr3 td{ border-top:#bdb09c 1px solid;
				 }
				.tr2 td{ border-bottom:#bdb09c 1px solid;
				border-top:#bdb09c 1px solid;
				 }
				 .itenararyPriceItem { color:#000000;
				font-family:arial;
				font-size:11px;
				font-weight:bold;
				 } 
				.itineraryPriceTotalHeader { background-color:#decfb5;
				border-bottom:#bdb29c 1px solid;
				border-left:#bdb29c 1px solid;
				border-right:#bdb29c 1px solid;
				border-sides:right bottom;
				border-top:#bdb29c 1px solid;
				font-family:arial;
				font-size:11px;
				font-weight:bold;
				text-align:left;
				vertical-align:middle;
				 }
				</style>
				<style type="text/css">.altova-rotate-left-textbox{-webkit-transform: rotate(-90deg) translate(-100%, 0%); -webkit-transform-origin: 0% 0%;-moz-transform: rotate(-90deg) translate(-100%, 0%); -moz-transform-origin: 0% 0%}.altova-rotate-right-textbox{-webkit-transform: rotate(90deg) translate(0%, -100%); -webkit-transform-origin: 0% 0%;-moz-transform: rotate(90deg) translate(0%, -100%); -moz-transform-origin: 0% 0%}</style>
				<style type="text/css">@page { margin-left:0.60in; margin-right:0.60in; margin-top:0.79in; margin-bottom:0.79in } @media print { br.altova-page-break { page-break-before: always; } }</style>
			</head>
			<body>
					<table class="headergrids" width="100%">
						<xsl:variable name="altova:CurrContextGrid_0BD872D8" select="."/>
						<tbody>
							<tr>
								<td align="left" class="labelSmallHeading">
									<span>
										<xsl:text>Customer #: </xsl:text>
									</span>
								</td>
								<td class="labelnoHeading">
									<span>
										<xsl:value-of select="substring($breakdownChargesHeader/customerNumber,6,10)"/>
									</span>
								</td>
								<td>
									<span>
										<xsl:text></xsl:text>
									</span>
								</td>
								<td align="left" class="labelSmallHeading">
									<span>
										<xsl:text>Reservation #: </xsl:text>
									</span>
								</td>
								<td class="labelnoHeading">
									<span>
										<xsl:value-of select="$bookingHeader/bookingNo"/>
									</span>
								</td>
								<td>
									<span>
										<xsl:text></xsl:text>
									</span>
								</td>
								<td align="right" class="labelnoHeading">
									<span>
										<xsl:value-of select="$breakdownChargesHeader/firstName"/> 
									</span>
								</td>
							</tr>
							<tr>
								<td align="left" class="labelSmallHeading">
									<span>
										<xsl:text>Booking Date: </xsl:text>
									</span>
								</td>
								<td class="labelnoHeading">
									<xsl:call-template name="FormatDateMMDDYYYY">
										<xsl:with-param name="DateTime" select="$bookingHeader/bookingDate"/>
									</xsl:call-template>
								</td>
								<td>
									<span>
										<xsl:text></xsl:text>
									</span>
								</td>
								<td align="left" class="labelSmallHeading">
									<span>
										<xsl:text>Booking Status: </xsl:text>
									</span>
								</td>
								<td class="labelnoHeading">
									<span>
										<xsl:value-of select="$bookingHeader/bookingStatus"/>
									</span>
								</td>
								<td>
									<span>
										<xsl:text></xsl:text>
									</span>
								</td>
								<td align="right" class="labelnoHeading">
									<span>
										<xsl:value-of select="$breakdownChargesHeader/address"/>
									</span>
								</td>
							</tr>
							<tr>
								<td align="left" class="labelSmallHeading">
									<span>
										<xsl:text>Voucher Date: </xsl:text>
									</span>
								</td>
								<td class="labelnoHeading">
									<xsl:call-template name="FormatDateMMDDYYYY">
										<xsl:with-param name="DateTime" select="$bookingHeader/voucherDate"/>
									</xsl:call-template>
								</td>
								<td>
									<span>
										<xsl:text></xsl:text>
									</span>
								</td>
								<td align="left" class="labelSmallHeading">
									<span>
										<xsl:text>Deposit Due: </xsl:text>
									</span>
								</td>
								<td class="labelnoHeading">
									<span>
										<xsl:text>$</xsl:text>
									</span>
									<xsl:call-template name="format-price">
										<xsl:with-param name="price">
											<xsl:value-of select="$breakdownChargesHeader/depositDue"/>
										</xsl:with-param>
									</xsl:call-template>	
								</td>
								<td>
									<span>
										<xsl:text></xsl:text>
									</span>
								</td>
								<td align="right" class="labelnoHeading">
									<span>
										<xsl:value-of select="$breakdownChargesHeader/city"/>
										<xsl:text> </xsl:text>
										<xsl:value-of select="$breakdownChargesHeader/state"/>
										<xsl:text> </xsl:text>
										<xsl:value-of select="$breakdownChargesHeader/postalCode"/>
									</span>
								</td>
							</tr>
							<tr>
								<td align="left" class="labelSmallHeading">
									<span>
										<xsl:text>Departure Date: </xsl:text>
									</span>
								</td>
								<td class="labelnoHeading">
									<xsl:call-template name="FormatDateMMDDYYYY">
										<xsl:with-param name="DateTime" select="$breakdownChargesHeader/departureDate"/>
									</xsl:call-template>
								</td>
								<td>
									<span>
										<xsl:text></xsl:text>
									</span>
								</td>
								<td align="left" class="labelSmallHeading">
									<span>
										<xsl:text>Duration: </xsl:text>
									</span>
								</td>
								<td class="labelnoHeading">
									<span>
										<xsl:value-of select="$breakdownChargesHeader/duration"/>
									</span>
								</td>
								<td colspan="2">
									<span>
										<xsl:text></xsl:text>
									</span>
								</td>
							</tr>
						</tbody>
					</table>
					<table>
						<xsl:variable name="altova:CurrContextGrid_0BA79268" select="."/>
						<tbody>
							<tr>
								<td height="25">
								</td>
							</tr>
							<tr>
								<td class="itenararyPriceItem">
										<xsl:text>Passenger Price Details </xsl:text>
								</td>
							</tr>
						</tbody>
					</table>
					<table class="itineraryPriceChargesGrid" width="100%">
						<xsl:variable name="altova:CurrContextGrid_0BD7B9F8" select="."/>
						<tbody>
							<tr>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>Pax Id</xsl:text>
									</span>
								</td>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>Title</xsl:text>
									</span>
								</td>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>First Name</xsl:text>
									</span>
								</td>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>Last Name</xsl:text>
									</span>
								</td>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>Age</xsl:text>
									</span>
								</td>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>Base Price</xsl:text>
									</span>
								</td>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>Car</xsl:text>
									</span>
								</td>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>Services</xsl:text>
									</span>
								</td>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>Insurance</xsl:text>
									</span>
								</td>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>Taxes</xsl:text>
									</span>
								</td>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>Fee</xsl:text>
									</span>
								</td>
								<td class="itineraryPriceTotalHeader">
									<span>
										<xsl:text>Total</xsl:text>
									</span>
								</td>
							</tr>
							<xsl:for-each select="$guestInfo">
							<tr>
								<td class="overNightVBox">
								
									<xsl:value-of select="guestId"/>
								</td>	
								<td>
									<xsl:value-of select="title"/>
								</td>
								<td>
									<xsl:value-of select="firstName"/>
								</td>
								<td>
									<span>
										<xsl:value-of select="lastName"/>
									</span>
								</td>
								<td>
									<span>
										<xsl:value-of select="age"/>
									</span>
								</td>
								<td>
									<span>
										<xsl:text>$</xsl:text>
									</span>
									<xsl:call-template name="format-price">
										<xsl:with-param name="price">
											<xsl:value-of select="priceBreakup/basePrice"/>
										</xsl:with-param>
									</xsl:call-template>	
								</td>
								<td>
									<span>
										<xsl:text>$</xsl:text>
									</span>
									<xsl:call-template name="format-price">
										<xsl:with-param name="price">
											<xsl:value-of select="priceBreakup/vehiclePrice"/>
										</xsl:with-param>
									</xsl:call-template>
								</td>
								<td>
									<span>
										<xsl:text>$</xsl:text>
									</span>
									<xsl:call-template name="format-price">
										<xsl:with-param name="price">
											<xsl:value-of select="priceBreakup/servicePrice"/>
										</xsl:with-param>
									</xsl:call-template>
								</td>
								<td>
									<span>
										<xsl:text>$</xsl:text>
									</span>
									<xsl:call-template name="format-price">
										<xsl:with-param name="price">
											<xsl:value-of select="priceBreakup/insurancePrice"/>
										</xsl:with-param>
									</xsl:call-template>
								</td>
								<td>
									<span>
										<xsl:text>$</xsl:text>
									</span>
									<xsl:call-template name="format-price">
										<xsl:with-param name="price">
											<xsl:value-of select="priceBreakup/taxPrice"/>
										</xsl:with-param>
									</xsl:call-template>
								</td>
								<td>
									<span>
										<xsl:text>$</xsl:text>
									</span>
									<xsl:call-template name="format-price">
										<xsl:with-param name="price">
											<xsl:value-of select="priceBreakup/fees"/>
										</xsl:with-param>
									</xsl:call-template>
								</td>
								<td class="itenararyPriceItem">
									<span>
										<xsl:text>$</xsl:text>
									</span>
									<xsl:call-template name="format-price">
										<xsl:with-param name="price">
											<xsl:value-of select="priceBreakup/totalPrice"/>
										</xsl:with-param>
									</xsl:call-template>
								</td>
							</tr>
							</xsl:for-each>
						</tbody>
					</table>
					<br/>
					<xsl:if test="$applicationInfo/type != 'TRAVEL_AGENT' ">					
					<table>						
						<tbody>
							<tr>
								<td class="internalusenotice">
									<span>
										<xsl:text>This information for INTERNAL USE ONLY</xsl:text>
									</span>
								</td>
							</tr>
						</tbody>
					</table>							
					<table class="itineraryPriceChargesGrid" width="100%">
						<xsl:variable name="altova:CurrContextGrid_0BD7BB78" select="."/>
						<tbody>
							<tr>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>Pax Id</xsl:text>
									</span>
								</td>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>First Name</xsl:text>
									</span>
								</td>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>Last Name</xsl:text>
									</span>
								</td>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>Description</xsl:text>
									</span>
								</td>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>Price</xsl:text>
									</span>
								</td>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>Net Price</xsl:text>
									</span>
								</td>
							</tr>
							<xsl:for-each select="$guestBreakdownCharge">
							<xsl:if test="paxId = '000000' ">
								<tr style="border-top:#bdb09c 1px solid" width="100%">
								<td colspan="1" style="border-top:#bdb09c 1px solid"></td>
								</tr>
							</xsl:if>
							<tr>
								<td>
								<xsl:if test="paxId != '000000' ">
								<xsl:value-of select="substring(paxId,6)"/>
								</xsl:if>
								</td>
								<td>
									<xsl:value-of select="firstName"/>
								</td>
							
								<td>
									<xsl:value-of select="lastName"/>
								</td>
								<xsl:if test="(chargeDescription = 'Subtotal') or (chargeDescription = 'Total')">
								<td align="right" class="itenararyPriceItem">
									<xsl:value-of select="chargeDescription"/>
								</td>
								<td align="right" class="itenararyPriceItem">
									<span>
										<xsl:text>$</xsl:text>
									</span>
									<xsl:call-template name="format-price">
										<xsl:with-param name="price">
											<xsl:value-of select="itemPrice"/>
										</xsl:with-param>
									</xsl:call-template>
								</td>
								<td align="right" class="itenararyPriceItem">
									<span>
										<xsl:text>$</xsl:text>
									</span>
									<xsl:call-template name="format-price">
										<xsl:with-param name="price">
											<xsl:value-of select="netPrice"/>
										</xsl:with-param>
									</xsl:call-template>
								</td>
								</xsl:if>
								<xsl:if test="(chargeDescription != 'Subtotal') and (chargeDescription != 'Total')">
								<td align="right">
									<xsl:value-of select="chargeDescription"/>
								</td>								
								<td align="right">
									<span>
										<xsl:text>$</xsl:text>
									</span>
									<xsl:call-template name="format-price">
										<xsl:with-param name="price">
											<xsl:value-of select="itemPrice"/>
										</xsl:with-param>
									</xsl:call-template>
								</td>
								<td align="right">
									<span>
										<xsl:text>$</xsl:text>
									</span>
									<xsl:call-template name="format-price">
										<xsl:with-param name="price">
											<xsl:value-of select="netPrice"/>
										</xsl:with-param>
									</xsl:call-template>
								</td>
								</xsl:if>
							</tr>
							<xsl:if test="paxId = '000000' ">
							<tr style="border-top:#bdb09c 1px solid" width="100%"/>
							</xsl:if>
							</xsl:for-each>
						</tbody>
					</table>
					</xsl:if>
					<table>
						<xsl:variable name="altova:CurrContextGrid_0BD73EC0" select="."/>
						<tbody>
							<tr>
								<td class="itenararyPriceItem">
										<xsl:text>Commission Details</xsl:text>
								</td>
							</tr>
						</tbody>
					</table>
					<table class="itineraryPriceChargesGrid" width="100%">
						<xsl:variable name="altova:CurrContextGrid_0BD80898" select="."/>
						<tbody>
							<tr>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text></xsl:text>
									</span>
								</td>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>Commissionable Amount</xsl:text>
									</span>
								</td>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>Commission %</xsl:text>
									</span>
								</td>
								<td class="itineraryPriceChargesHeader">
									<span>
										<xsl:text>Commission</xsl:text>
									</span>
								</td>
							</tr>
							<xsl:for-each select="$guestBreakdownCommissionCharge">
							<tr>
								<td>
									<xsl:value-of select="materialGroupDescription"/>
								</td>
								<xsl:if test="(materialGroupDescription = 'Total') and ($applicationInfo/type != 'TRAVEL_AGENT')">
								<td>
									<span>
										<xsl:text>$</xsl:text>
									</span>
									<xsl:call-template name="format-price">
										<xsl:with-param name="price">
											<xsl:value-of select="commissionableAmount"/>
										</xsl:with-param>
									</xsl:call-template>
								</td>
								</xsl:if>
								<xsl:if test="(materialGroupDescription = 'Total') and ($applicationInfo/type = 'TRAVEL_AGENT')">
								<td>
									<xsl:text>-</xsl:text>
								</td>
								</xsl:if>
								<xsl:if test="(materialGroupDescription != 'Total') and ($applicationInfo/type != 'TRAVEL_AGENT')">
								<td>
									<span>
										<xsl:text>$</xsl:text>
									</span>
									<xsl:call-template name="format-price">
										<xsl:with-param name="price">
											<xsl:value-of select="commissionableAmount"/>
										</xsl:with-param>
									</xsl:call-template>								
								</td>
								</xsl:if>
								<xsl:if test="(materialGroupDescription != 'Total') and ($applicationInfo/type = 'TRAVEL_AGENT')">
								<td>
									<xsl:text>-</xsl:text>
								</td>
								</xsl:if>
								<td>
									<xsl:call-template name="format-price">
										<xsl:with-param name="price">
											<xsl:value-of select="commissionPercent"/>
										</xsl:with-param>
									</xsl:call-template>
									<span>
										<xsl:text>%</xsl:text>
									</span>
								</td>
								<xsl:if test="materialGroupDescription = 'Total' ">
								<td>
									<span>
										<xsl:text>$</xsl:text>
									</span>
									<xsl:call-template name="format-price">
										<xsl:with-param name="price">
											<xsl:value-of select="commissionAmount"/>
										</xsl:with-param>
									</xsl:call-template>
								</td>
								</xsl:if>
								<xsl:if test="(materialGroupDescription != 'Total') and ($applicationInfo/type != 'TRAVEL_AGENT')">
								<td>
									<span>
										<xsl:text>$</xsl:text>
									</span>
									<xsl:call-template name="format-price">
										<xsl:with-param name="price">
											<xsl:value-of select="commissionAmount"/>
										</xsl:with-param>
									</xsl:call-template>							
								</td>
								</xsl:if>
								<xsl:if test="(materialGroupDescription != 'Total') and ($applicationInfo/type = 'TRAVEL_AGENT')">
								<td>
									<xsl:text>-</xsl:text>
								</td>
								</xsl:if>
							</tr>
							</xsl:for-each>
						</tbody>
					</table>
			</body>
		</html>
	</xsl:template>
	<xsl:template name="format-price">
	  <xsl:param name="price"/>
	  <xsl:value-of	select="format-number($price, '#,##0.00')"/>
	</xsl:template>
	<xsl:template name="FormatDateMMDDYYYY">
	    <xsl:param name="DateTime" />
	    <!-- new date format 2010-10-13 00:00:00.0 EDT -->
	    <xsl:variable name="year">
	      <xsl:value-of select="substring($DateTime,1,4)" />
	    </xsl:variable>
	    <xsl:variable name="mo">
	      <xsl:value-of select="substring($DateTime,6,2)" />
	    </xsl:variable>
	    <xsl:variable name="day">
	      <xsl:value-of select="substring($DateTime,9,2)" />
	    </xsl:variable>
	    <xsl:variable name="hh">
	      <xsl:value-of select="substring($DateTime,12,2)" />
	    </xsl:variable>
	    <xsl:variable name="mm">
	      <xsl:value-of select="substring($DateTime,15,2)" />
	    </xsl:variable>
	    <xsl:variable name="ss">
	      <xsl:value-of select="substring($DateTime,18,2)" />
	    </xsl:variable>
	    <xsl:value-of select="$mo"/>
	    <xsl:text>/</xsl:text>
	    <xsl:value-of select="$day"/>
	    <xsl:text>/</xsl:text>
	    <xsl:value-of select="$year"/>
	</xsl:template>
</xsl:stylesheet>