package com.kcdata.abe.bapi;
public class Zapi_Prd_Airline_InfoType extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1247175272265L) ;

    private  Zapi_Prd_Airline_InfoType.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.XSDL_COMPLEX_TYPE, "urn:sap-com:document:sap:rfc:functions", "ZAPI_PRD_AIRLINE_INFO", 25, 0, com.kcdata.abe.bapi.Zapi_Prd_Airline_InfoType.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "ZAPI_PRD_AIRLINE_INFO", 2316, 4632, -1, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPI_PRD_AIRLINE_INFO\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Structure for Airline Information - SAP_Product</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>2316</ifr:internalLength1><ifr:internalLength2>4632</ifr:internalLength2></ifr:definition></ifr:container></s0:type>");
        descriptorSetElementProperties(descriptor, 0, "AIRLINENAME", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Airlinename", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "50"}}, "AIRLINENAME", 0, 0, -1, 50, 100, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"AIRLINENAME\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Airline Name</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>0</ifr:offset1><ifr:offset2>0</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZCNAM\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>50</ifr:length><ifr:internalLength1>50</ifr:internalLength1><ifr:internalLength2>100</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>50</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 1, "HEADQUARTERS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Headquarters", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "50"}}, "HEADQUARTERS", 50, 100, -1, 50, 100, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"HEADQUARTERS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Airline Headquarter</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>50</ifr:offset1><ifr:offset2>100</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZHEADQT\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>50</ifr:length><ifr:internalLength1>50</ifr:internalLength1><ifr:internalLength2>100</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>50</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 2, "AIRLINEESTABLISHED", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Airlineestablished", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "4"}}, "AIRLINEESTABLISHED", 100, 200, -1, 4, 8, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"AIRLINEESTABLISHED\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Airline Established</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>100</ifr:offset1><ifr:offset2>200</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZALESTD\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>4</ifr:length><ifr:internalLength1>4</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>4</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 3, "TELEPHONENUMBER", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Telephonenumber", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "13"}}, "TELEPHONENUMBER", 104, 208, -1, 13, 26, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"TELEPHONENUMBER\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Phone No of Pax</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>104</ifr:offset1><ifr:offset2>208</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZPHONE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>13</ifr:length><ifr:internalLength1>13</ifr:internalLength1><ifr:internalLength2>26</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>13</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 4, "ONTIMEPERFORMANCE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ontimeperformance", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "30"}}, "ONTIMEPERFORMANCE", 117, 234, -1, 30, 60, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ONTIMEPERFORMANCE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Apple Performance Rating</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>117</ifr:offset1><ifr:offset2>234</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZPERFORM\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>30</ifr:length><ifr:internalLength1>30</ifr:internalLength1><ifr:internalLength2>60</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>30</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 5, "EXTRABAGGAGECOST", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Extrabaggagecost", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "20"}}, "EXTRABAGGAGECOST", 147, 294, -1, 20, 40, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"EXTRABAGGAGECOST\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Extra Baggage Cost</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>147</ifr:offset1><ifr:offset2>294</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZXBAGCOST\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>20</ifr:length><ifr:internalLength1>20</ifr:internalLength1><ifr:internalLength2>40</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>20</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 6, "CHILDCARSEAT", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Childcarseat", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "50"}}, "CHILDCARSEAT", 167, 334, -1, 50, 100, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CHILDCARSEAT\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Child Car Seat</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>167</ifr:offset1><ifr:offset2>334</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZCCARSEAT\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>50</ifr:length><ifr:internalLength1>50</ifr:internalLength1><ifr:internalLength2>100</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>50</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 7, "FIREARMSWEAPON", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Firearmsweapon", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "50"}}, "FIREARMSWEAPON", 217, 434, -1, 50, 100, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"FIREARMSWEAPON\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Fire Arms and Weapons</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>217</ifr:offset1><ifr:offset2>434</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZFIREWPON\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>50</ifr:length><ifr:internalLength1>50</ifr:internalLength1><ifr:internalLength2>100</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>50</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 8, "OXYGEN", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Oxygen", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "50"}}, "OXYGEN", 267, 534, -1, 50, 100, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"OXYGEN\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Oxygen</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>267</ifr:offset1><ifr:offset2>534</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZOXYGEN\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>50</ifr:length><ifr:internalLength1>50</ifr:internalLength1><ifr:internalLength2>100</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>50</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 9, "PETS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Pets", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "50"}}, "PETS", 317, 634, -1, 50, 100, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"PETS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Pets</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>317</ifr:offset1><ifr:offset2>634</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZPETS\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>50</ifr:length><ifr:internalLength1>50</ifr:internalLength1><ifr:internalLength2>100</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>50</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 10, "SEATBELTEXTENSION", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Seatbeltextension", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "100"}}, "SEATBELTEXTENSION", 367, 734, -1, 100, 200, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"SEATBELTEXTENSION\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Seat Belt Extension</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>367</ifr:offset1><ifr:offset2>734</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZSEATBEXT\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>100</ifr:length><ifr:internalLength1>100</ifr:internalLength1><ifr:internalLength2>200</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>100</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 11, "LOSTBAGGAGENUMBER", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Lostbaggagenumber", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "20"}}, "LOSTBAGGAGENUMBER", 467, 934, -1, 20, 40, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"LOSTBAGGAGENUMBER\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Lost baggage number</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>467</ifr:offset1><ifr:offset2>934</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZLOSTBGNO\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>20</ifr:length><ifr:internalLength1>20</ifr:internalLength1><ifr:internalLength2>40</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>20</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 12, "WHEELCHRAIR", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Wheelchrair", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "20"}}, "WHEELCHRAIR", 487, 974, -1, 20, 40, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"WHEELCHRAIR\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Wheel Chairs Wet of Dry cell</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>487</ifr:offset1><ifr:offset2>974</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZWHCHR\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>20</ifr:length><ifr:internalLength1>20</ifr:internalLength1><ifr:internalLength2>40</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>20</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 13, "GOLDENAPPLESERV", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Goldenappleserv", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "50"}}, "GOLDENAPPLESERV", 507, 1014, -1, 50, 100, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"GOLDENAPPLESERV\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Golden Apple Inflight Service</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>507</ifr:offset1><ifr:offset2>1014</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZGDAPPSRV\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>50</ifr:length><ifr:internalLength1>50</ifr:internalLength1><ifr:internalLength2>100</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>50</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 14, "HANDICAPINFORMATION", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Handicapinformation", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "50"}}, "HANDICAPINFORMATION", 557, 1114, -1, 50, 100, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"HANDICAPINFORMATION\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Handicap Information</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>557</ifr:offset1><ifr:offset2>1114</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZHANDICAP\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>50</ifr:length><ifr:internalLength1>50</ifr:internalLength1><ifr:internalLength2>100</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>50</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 15, "SPECIALMEALREQUEST", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Specialmealrequest", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "50"}}, "SPECIALMEALREQUEST", 607, 1214, -1, 50, 100, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"SPECIALMEALREQUEST\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Special Meal Request</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>607</ifr:offset1><ifr:offset2>1214</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZSPLMEAL\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>50</ifr:length><ifr:internalLength1>50</ifr:internalLength1><ifr:internalLength2>100</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>50</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 16, "CHECKEDBAGGAGE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Checkedbaggage", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "200"}}, "CHECKEDBAGGAGE", 657, 1314, -1, 200, 400, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CHECKEDBAGGAGE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Checked Baggage</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>657</ifr:offset1><ifr:offset2>1314</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZCHKBAG\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>200</ifr:length><ifr:internalLength1>200</ifr:internalLength1><ifr:internalLength2>400</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>200</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 17, "AIRCRAFTTYPE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Aircrafttype", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "255"}}, "AIRCRAFTTYPE", 857, 1714, -1, 255, 510, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"AIRCRAFTTYPE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Aircraft Type used</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>857</ifr:offset1><ifr:offset2>1714</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZACTYPE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>255</ifr:length><ifr:internalLength1>255</ifr:internalLength1><ifr:internalLength2>510</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>255</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 18, "CARRYONBAGGAGE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Carryonbaggage", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "200"}}, "CARRYONBAGGAGE", 1112, 2224, -1, 200, 400, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CARRYONBAGGAGE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Carry on Baggage</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1112</ifr:offset1><ifr:offset2>2224</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZCRONBAG\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>200</ifr:length><ifr:internalLength1>200</ifr:internalLength1><ifr:internalLength2>400</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>200</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 19, "BICYCLES", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Bicycles", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "200"}}, "BICYCLES", 1312, 2624, -1, 200, 400, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"BICYCLES\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Bicycles</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1312</ifr:offset1><ifr:offset2>2624</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZBICYCLES\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>200</ifr:length><ifr:internalLength1>200</ifr:internalLength1><ifr:internalLength2>400</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>200</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 20, "GOLFCLUBS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Golfclubs", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "200"}}, "GOLFCLUBS", 1512, 3024, -1, 200, 400, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"GOLFCLUBS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Golf clubs</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1512</ifr:offset1><ifr:offset2>3024</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZGOLFCLUB\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>200</ifr:length><ifr:internalLength1>200</ifr:internalLength1><ifr:internalLength2>400</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>200</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 21, "SCUBAEQUIPMENT", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Scubaequipment", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "200"}}, "SCUBAEQUIPMENT", 1712, 3424, -1, 200, 400, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"SCUBAEQUIPMENT\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Scuba Equipment</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1712</ifr:offset1><ifr:offset2>3424</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZSCEQUIP\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>200</ifr:length><ifr:internalLength1>200</ifr:internalLength1><ifr:internalLength2>400</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>200</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 22, "SURFBOARD", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Surfboard", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "200"}}, "SURFBOARD", 1912, 3824, -1, 200, 400, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"SURFBOARD\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Surf Board</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1912</ifr:offset1><ifr:offset2>3824</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZSURFBRD\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>200</ifr:length><ifr:internalLength1>200</ifr:internalLength1><ifr:internalLength2>400</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>200</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 23, "WEDDINGGOWN", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Weddinggown", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "200"}}, "WEDDINGGOWN", 2112, 4224, -1, 200, 400, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"WEDDINGGOWN\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Wedding Gown</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>2112</ifr:offset1><ifr:offset2>4224</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZWEDGOWN\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>200</ifr:length><ifr:internalLength1>200</ifr:internalLength1><ifr:internalLength2>400</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>200</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 24, "SEATCAP", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Seatcap", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "4"}}, "SEATCAP", 2312, 4624, -1, 4, 8, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"SEATCAP\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Aircraft Seat Capacity</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>2312</ifr:offset1><ifr:offset2>4624</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZSEATCAP\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>4</ifr:length><ifr:internalLength1>4</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>4</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        staticDescriptor = descriptor;
    }
    public  Zapi_Prd_Airline_InfoType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Zapi_Prd_Airline_InfoType (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public java.lang.String getPets() {
        return (java.lang.String)baseTypeData().getElementValueAsString(9);
    }

    public void setGoldenappleserv(java.lang.String Goldenappleserv) {
        baseTypeData().setElementValue(13, Goldenappleserv);
    }

    public void setSpecialmealrequest(java.lang.String Specialmealrequest) {
        baseTypeData().setElementValue(15, Specialmealrequest);
    }

    public java.lang.String getCheckedbaggage() {
        return (java.lang.String)baseTypeData().getElementValueAsString(16);
    }

    public void setOxygen(java.lang.String Oxygen) {
        baseTypeData().setElementValue(8, Oxygen);
    }

    public void setWeddinggown(java.lang.String Weddinggown) {
        baseTypeData().setElementValue(23, Weddinggown);
    }

    public java.lang.String getSeatcap() {
        return (java.lang.String)baseTypeData().getElementValueAsString(24);
    }

    public void setAirlinename(java.lang.String Airlinename) {
        baseTypeData().setElementValue(0, Airlinename);
    }

    public java.lang.String getGolfclubs() {
        return (java.lang.String)baseTypeData().getElementValueAsString(20);
    }

    public void setHandicapinformation(java.lang.String Handicapinformation) {
        baseTypeData().setElementValue(14, Handicapinformation);
    }

    public void setWheelchrair(java.lang.String Wheelchrair) {
        baseTypeData().setElementValue(12, Wheelchrair);
    }

    public void setAircrafttype(java.lang.String Aircrafttype) {
        baseTypeData().setElementValue(17, Aircrafttype);
    }

    public void setBicycles(java.lang.String Bicycles) {
        baseTypeData().setElementValue(19, Bicycles);
    }

    public java.lang.String getChildcarseat() {
        return (java.lang.String)baseTypeData().getElementValueAsString(6);
    }

    public void setSurfboard(java.lang.String Surfboard) {
        baseTypeData().setElementValue(22, Surfboard);
    }

    public java.lang.String getTelephonenumber() {
        return (java.lang.String)baseTypeData().getElementValueAsString(3);
    }

    public java.lang.String getSeatbeltextension() {
        return (java.lang.String)baseTypeData().getElementValueAsString(10);
    }

    public void setChildcarseat(java.lang.String Childcarseat) {
        baseTypeData().setElementValue(6, Childcarseat);
    }

    public void setCarryonbaggage(java.lang.String Carryonbaggage) {
        baseTypeData().setElementValue(18, Carryonbaggage);
    }

    public java.lang.String getHeadquarters() {
        return (java.lang.String)baseTypeData().getElementValueAsString(1);
    }

    public void setHeadquarters(java.lang.String Headquarters) {
        baseTypeData().setElementValue(1, Headquarters);
    }

    public java.lang.String getAircrafttype() {
        return (java.lang.String)baseTypeData().getElementValueAsString(17);
    }

    public void setGolfclubs(java.lang.String Golfclubs) {
        baseTypeData().setElementValue(20, Golfclubs);
    }

    public void setExtrabaggagecost(java.lang.String Extrabaggagecost) {
        baseTypeData().setElementValue(5, Extrabaggagecost);
    }

    public void setCheckedbaggage(java.lang.String Checkedbaggage) {
        baseTypeData().setElementValue(16, Checkedbaggage);
    }

    public java.lang.String getHandicapinformation() {
        return (java.lang.String)baseTypeData().getElementValueAsString(14);
    }

    public java.lang.String getWheelchrair() {
        return (java.lang.String)baseTypeData().getElementValueAsString(12);
    }

    public java.lang.String getBicycles() {
        return (java.lang.String)baseTypeData().getElementValueAsString(19);
    }

    public void setTelephonenumber(java.lang.String Telephonenumber) {
        baseTypeData().setElementValue(3, Telephonenumber);
    }

    public void setSeatbeltextension(java.lang.String Seatbeltextension) {
        baseTypeData().setElementValue(10, Seatbeltextension);
    }

    public void setLostbaggagenumber(java.lang.String Lostbaggagenumber) {
        baseTypeData().setElementValue(11, Lostbaggagenumber);
    }

    public java.lang.String getExtrabaggagecost() {
        return (java.lang.String)baseTypeData().getElementValueAsString(5);
    }

    public java.lang.String getSurfboard() {
        return (java.lang.String)baseTypeData().getElementValueAsString(22);
    }

    public java.lang.String getFirearmsweapon() {
        return (java.lang.String)baseTypeData().getElementValueAsString(7);
    }

    public java.lang.String getAirlineestablished() {
        return (java.lang.String)baseTypeData().getElementValueAsString(2);
    }

    public void setAirlineestablished(java.lang.String Airlineestablished) {
        baseTypeData().setElementValue(2, Airlineestablished);
    }

    public java.lang.String getSpecialmealrequest() {
        return (java.lang.String)baseTypeData().getElementValueAsString(15);
    }

    public java.lang.String getLostbaggagenumber() {
        return (java.lang.String)baseTypeData().getElementValueAsString(11);
    }

    public java.lang.String getWeddinggown() {
        return (java.lang.String)baseTypeData().getElementValueAsString(23);
    }

    public java.lang.String getCarryonbaggage() {
        return (java.lang.String)baseTypeData().getElementValueAsString(18);
    }

    public MetaData metadata() {
        return metadata;
    }

    public void setPets(java.lang.String Pets) {
        baseTypeData().setElementValue(9, Pets);
    }

    public void setScubaequipment(java.lang.String Scubaequipment) {
        baseTypeData().setElementValue(21, Scubaequipment);
    }

    public void setFirearmsweapon(java.lang.String Firearmsweapon) {
        baseTypeData().setElementValue(7, Firearmsweapon);
    }

    public java.lang.String getGoldenappleserv() {
        return (java.lang.String)baseTypeData().getElementValueAsString(13);
    }

    public void setOntimeperformance(java.lang.String Ontimeperformance) {
        baseTypeData().setElementValue(4, Ontimeperformance);
    }

    public java.lang.String getScubaequipment() {
        return (java.lang.String)baseTypeData().getElementValueAsString(21);
    }

    public java.lang.String getOxygen() {
        return (java.lang.String)baseTypeData().getElementValueAsString(8);
    }

    public java.lang.String getOntimeperformance() {
        return (java.lang.String)baseTypeData().getElementValueAsString(4);
    }

    public void setSeatcap(java.lang.String Seatcap) {
        baseTypeData().setElementValue(24, Seatcap);
    }

    public java.lang.String getAirlinename() {
        return (java.lang.String)baseTypeData().getElementValueAsString(0);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Zapi_Prd_Airline_InfoType parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Zapi_Prd_Airline_InfoType parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getExtrabaggagecost() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getSurfboard() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(22);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getPets() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(9);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getFirearmsweapon() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(7);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getAirlineestablished() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getSpecialmealrequest() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(15);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getLostbaggagenumber() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(11);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getWeddinggown() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(23);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCheckedbaggage() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(16);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getSeatcap() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(24);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCarryonbaggage() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(18);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getGolfclubs() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(20);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getChildcarseat() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(6);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getTelephonenumber() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getSeatbeltextension() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(10);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getHeadquarters() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getAircrafttype() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(17);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getGoldenappleserv() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(13);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getScubaequipment() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(21);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getOxygen() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(8);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getOntimeperformance() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getAirlinename() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getHandicapinformation() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(14);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getWheelchrair() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(12);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getBicycles() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(19);
        }
    
    }

}
