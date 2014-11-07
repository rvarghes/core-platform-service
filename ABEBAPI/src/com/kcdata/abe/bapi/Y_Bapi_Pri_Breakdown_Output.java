package com.kcdata.abe.bapi;
public class Y_Bapi_Pri_Breakdown_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1299152628062L) ;

    private  Y_Bapi_Pri_Breakdown_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_BAPI_PRI_BREAKDOWN.Output", 17, 0, com.kcdata.abe.bapi.Y_Bapi_Pri_Breakdown_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_BAPI_PRI_BREAKDOWN", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Display Charges</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "BOOKINGDATE", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:date", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Bookingdate", java.sql.Date.class, null, new java.lang.String[][]{}, "BOOKINGDATE", 0, 0, -1, 8, 16, -1, com.sap.mw.jco.JCO.TYPE_DATE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"BOOKINGDATE\"><ifr:descriptor><ifr:description language=\"EN\">Booking date</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"ZISSTS.BUDAT\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>16</ifr:offset1><ifr:offset2>32</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"BUDAT\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>DATS</ifr:type><ifr:abapType>D</ifr:abapType><ifr:length>8</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>16</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "BOOKINGSTATUS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Bookingstatus", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "10"}}, "BOOKINGSTATUS", 0, 0, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"BOOKINGSTATUS\"><ifr:descriptor><ifr:description language=\"EN\">Status of Booking</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"ZISSTS.ZZBKST\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:checkTable>ZISSBS</ifr:checkTable><ifr:offset1>43</ifr:offset1><ifr:offset2>68</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"ZZBKST\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "CITY", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "City", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "35"}}, "CITY", 0, 0, -1, 35, 70, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"CITY\"><ifr:descriptor><ifr:description language=\"EN\">City</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"KNA1.ORT01\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>86</ifr:offset1><ifr:offset2>172</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"ORT01_GP\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>35</ifr:length><ifr:internalLength1>35</ifr:internalLength1><ifr:internalLength2>70</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>35</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "CUSTOMERNAME", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Customername", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "35"}}, "CUSTOMERNAME", 0, 0, -1, 35, 70, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"CUSTOMERNAME\"><ifr:descriptor><ifr:description language=\"EN\">Customer First Name</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"KNA1.NAME1\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>16</ifr:offset1><ifr:offset2>32</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"NAME1_GP\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>35</ifr:length><ifr:internalLength1>35</ifr:internalLength1><ifr:internalLength2>70</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>35</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "CUSTOMERNAME2", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Customername2", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "35"}}, "CUSTOMERNAME2", 0, 0, -1, 35, 70, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"CUSTOMERNAME2\"><ifr:descriptor><ifr:description language=\"EN\">Customer Last Name</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"KNA1.NAME2\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>51</ifr:offset1><ifr:offset2>102</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"NAME2_GP\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>35</ifr:length><ifr:internalLength1>35</ifr:internalLength1><ifr:internalLength2>70</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>35</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 5, "CUSTOMERNUMBER", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Customernumber", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "10"}}, "CUSTOMERNUMBER", 0, 0, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"CUSTOMERNUMBER\"><ifr:descriptor><ifr:description language=\"EN\">Customer Code</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"KNA1.KUNNR\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>3</ifr:offset1><ifr:offset2>6</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"KUNNR\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength><ifr:conversionExit>ALPHA</ifr:conversionExit></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 6, "DEPARTUREDATE", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:date", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Departuredate", java.sql.Date.class, null, new java.lang.String[][]{}, "DEPARTUREDATE", 0, 0, -1, 8, 16, -1, com.sap.mw.jco.JCO.TYPE_DATE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"DEPARTUREDATE\"><ifr:descriptor><ifr:description language=\"EN\">Departure Date</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"ZISSTS.ZZDEPDATE\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>119</ifr:offset1><ifr:offset2>206</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"BUDAT\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>DATS</ifr:type><ifr:abapType>D</ifr:abapType><ifr:length>8</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>16</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 7, "DEPOSITDUE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Depositdue", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "11"}, {"fractionDigits", "2"}}, "DEPOSITDUE", 0, 0, -1, 6, 6, -1, com.sap.mw.jco.JCO.TYPE_BCD, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"DEPOSITDUE\"><ifr:descriptor><ifr:description language=\"EN\">Deposit Due</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"ZISSTS.ZZTOUR_PR\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>PSWSL</ifr:referenceField><ifr:referenceTable>BSEG</ifr:referenceTable><ifr:offset1>24</ifr:offset1><ifr:offset2>48</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"Z_NETWR_AK\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>true</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>11</ifr:length><ifr:internalLength1>6</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>15</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 8, "DURATION", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Duration", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "DURATION", 0, 0, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"DURATION\"><ifr:descriptor><ifr:description language=\"EN\">Duration</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"ZSQTH.ZZDURATION\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>78</ifr:offset1><ifr:offset2>156</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"ZZDURATION\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 9, "HOUSENUMBERSTREET", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Housenumberstreet", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "35"}}, "HOUSENUMBERSTREET", 0, 0, -1, 35, 70, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"HOUSENUMBERSTREET\"><ifr:descriptor><ifr:description language=\"EN\">House Number / Street of Customer</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"KNA1.STRAS\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>144</ifr:offset1><ifr:offset2>288</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"STRAS_GP\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>35</ifr:length><ifr:internalLength1>35</ifr:internalLength1><ifr:internalLength2>70</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>35</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 10, "POSTALCODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Postalcode", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "10"}}, "POSTALCODE", 0, 0, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"POSTALCODE\"><ifr:descriptor><ifr:description language=\"EN\">Postal Code</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"KNA1.PSTLZ\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>121</ifr:offset1><ifr:offset2>242</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"PSTLZ\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 11, "REGIONSTATE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Regionstate", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "3"}}, "REGIONSTATE", 0, 0, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"REGIONSTATE\"><ifr:descriptor><ifr:description language=\"EN\">Region / State</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"KNA1.REGIO\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:checkTable>T005S</ifr:checkTable><ifr:offset1>131</ifr:offset1><ifr:offset2>262</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"REGIO\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 12, "RETURN", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:BAPIRETURN", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Return", com.kcdata.abe.bapi.BapireturnType.class, new com.kcdata.abe.bapi.BapireturnType(), new java.lang.String[][]{}, "RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Message</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRETURN\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRETURN\" /></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 13, "MATERIAL_PRICE", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Material_Price", com.kcdata.abe.bapi.util.Zapi_Matl_PriceType_List.class, new com.kcdata.abe.bapi.Zapi_Matl_PriceType(), new java.lang.String[][]{}, "MATERIAL_PRICE", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"MATERIAL_PRICE\"><ifr:descriptor><ifr:description language=\"EN\">Commission Details</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_MATL_PRICE\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_MATL_PRICE\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 14, "HEADERPRICES", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Headerprices", com.kcdata.abe.bapi.util.Zapi_Pax_InfoType_List.class, new com.kcdata.abe.bapi.Zapi_Pax_InfoType(), new java.lang.String[][]{}, "HEADERPRICES", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"HEADERPRICES\"><ifr:descriptor><ifr:description language=\"EN\">Header Price Information</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_PAX_INFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_PAX_INFO\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 15, "DETAILPRICES", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Detailprices", com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailType_List.class, new com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType(), new java.lang.String[][]{}, "DETAILPRICES", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"DETAILPRICES\"><ifr:descriptor><ifr:description language=\"EN\">Detail Price Information</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_PAX_INFO_DETAIL\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_PAX_INFO_DETAIL\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 16, "COMMISSIONDTLS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Commissiondtls", com.kcdata.abe.bapi.util.Zapi_Commission_DtlsType_List.class, new com.kcdata.abe.bapi.Zapi_Commission_DtlsType(), new java.lang.String[][]{}, "COMMISSIONDTLS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"COMMISSIONDTLS\"><ifr:descriptor><ifr:description language=\"EN\">Commission Details</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_COMMISSION_DTLS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_COMMISSION_DTLS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    protected  Y_Bapi_Pri_Breakdown_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Y_Bapi_Pri_Breakdown_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void setBookingdate(java.sql.Date Bookingdate) {
        baseTypeData().setElementValue(0, Bookingdate);
    }

    public void setCommissiondtls(com.kcdata.abe.bapi.util.Zapi_Commission_DtlsType_List Commissiondtls) {
        baseTypeData().setElementValue(16, Commissiondtls);
    }

    public void setHeaderprices(com.kcdata.abe.bapi.util.Zapi_Pax_InfoType_List Headerprices) {
        baseTypeData().setElementValue(14, Headerprices);
    }

    public void setDuration(java.lang.String Duration) {
        baseTypeData().setElementValue(8, Duration);
    }

    public java.lang.String getDuration() {
        return (java.lang.String)baseTypeData().getElementValueAsString(8);
    }

    public com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType[] getDetailprices() {
        com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailType_List i$ = (com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailType_List)baseTypeData().getElementValue(15);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_Pax_Info_DetailType();
    }

    public void setMaterial_Price(com.kcdata.abe.bapi.Zapi_Matl_PriceType[] Material_Price) {
        baseTypeData().setElementValue(13, new com.kcdata.abe.bapi.util.Zapi_Matl_PriceType_List());
        com.kcdata.abe.bapi.util.Zapi_Matl_PriceType_List list$ = get_as_listMaterial_Price();
        for (int  i$ = 0; i$ < Material_Price.length; i$++){
         list$.addZapi_Matl_PriceType(Material_Price[ i$]);
        }
    }

    public java.lang.String getCustomernumber() {
        return (java.lang.String)baseTypeData().getElementValueAsString(5);
    }

    public void setDetailprices(com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType[] Detailprices) {
        baseTypeData().setElementValue(15, new com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailType_List());
        com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailType_List list$ = get_as_listDetailprices();
        for (int  i$ = 0; i$ < Detailprices.length; i$++){
         list$.addZapi_Pax_Info_DetailType(Detailprices[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Zapi_Matl_PriceType_List get_as_listMaterial_Price() {
        return (com.kcdata.abe.bapi.util.Zapi_Matl_PriceType_List)baseTypeData().getElementValue(13);
    }

    public void setBookingstatus(java.lang.String Bookingstatus) {
        baseTypeData().setElementValue(1, Bookingstatus);
    }

    public void setReturn(com.kcdata.abe.bapi.BapireturnType Return) {
        baseTypeData().setElementValue(12, Return);
    }

    public java.sql.Date getBookingdate() {
        return (java.sql.Date)baseTypeData().getElementValueAsDate(0);
    }

    public void setDepositdue(java.math.BigDecimal Depositdue) {
        baseTypeData().setElementValue(7, Depositdue);
    }

    public void setRegionstate(java.lang.String Regionstate) {
        baseTypeData().setElementValue(11, Regionstate);
    }

    public com.kcdata.abe.bapi.Zapi_Matl_PriceType[] getMaterial_Price() {
        com.kcdata.abe.bapi.util.Zapi_Matl_PriceType_List i$ = (com.kcdata.abe.bapi.util.Zapi_Matl_PriceType_List)baseTypeData().getElementValue(13);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_Matl_PriceType();
    }

    public java.lang.String getBookingstatus() {
        return (java.lang.String)baseTypeData().getElementValueAsString(1);
    }

    public void setPostalcode(java.lang.String Postalcode) {
        baseTypeData().setElementValue(10, Postalcode);
    }

    public java.lang.String getRegionstate() {
        return (java.lang.String)baseTypeData().getElementValueAsString(11);
    }

    public com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailType_List get_as_listDetailprices() {
        return (com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailType_List)baseTypeData().getElementValue(15);
    }

    public java.sql.Date getDeparturedate() {
        return (java.sql.Date)baseTypeData().getElementValueAsDate(6);
    }

    public void setHeaderprices(com.kcdata.abe.bapi.Zapi_Pax_InfoType[] Headerprices) {
        baseTypeData().setElementValue(14, new com.kcdata.abe.bapi.util.Zapi_Pax_InfoType_List());
        com.kcdata.abe.bapi.util.Zapi_Pax_InfoType_List list$ = get_as_listHeaderprices();
        for (int  i$ = 0; i$ < Headerprices.length; i$++){
         list$.addZapi_Pax_InfoType(Headerprices[ i$]);
        }
    }

    public void setDeparturedate(java.sql.Date Departuredate) {
        baseTypeData().setElementValue(6, Departuredate);
    }

    public com.kcdata.abe.bapi.Zapi_Pax_InfoType[] getHeaderprices() {
        com.kcdata.abe.bapi.util.Zapi_Pax_InfoType_List i$ = (com.kcdata.abe.bapi.util.Zapi_Pax_InfoType_List)baseTypeData().getElementValue(14);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_Pax_InfoType();
    }

    public com.kcdata.abe.bapi.util.Zapi_Pax_InfoType_List get_as_listHeaderprices() {
        return (com.kcdata.abe.bapi.util.Zapi_Pax_InfoType_List)baseTypeData().getElementValue(14);
    }

    public com.kcdata.abe.bapi.BapireturnType getReturn() {
        return (com.kcdata.abe.bapi.BapireturnType)baseTypeData().getElementValue(12);
    }

    public java.lang.String getPostalcode() {
        return (java.lang.String)baseTypeData().getElementValueAsString(10);
    }

    public void setCommissiondtls(com.kcdata.abe.bapi.Zapi_Commission_DtlsType[] Commissiondtls) {
        baseTypeData().setElementValue(16, new com.kcdata.abe.bapi.util.Zapi_Commission_DtlsType_List());
        com.kcdata.abe.bapi.util.Zapi_Commission_DtlsType_List list$ = get_as_listCommissiondtls();
        for (int  i$ = 0; i$ < Commissiondtls.length; i$++){
         list$.addZapi_Commission_DtlsType(Commissiondtls[ i$]);
        }
    }

    public void setCustomernumber(java.lang.String Customernumber) {
        baseTypeData().setElementValue(5, Customernumber);
    }

    public void setCity(java.lang.String City) {
        baseTypeData().setElementValue(2, City);
    }

    public com.kcdata.abe.bapi.Zapi_Commission_DtlsType[] getCommissiondtls() {
        com.kcdata.abe.bapi.util.Zapi_Commission_DtlsType_List i$ = (com.kcdata.abe.bapi.util.Zapi_Commission_DtlsType_List)baseTypeData().getElementValue(16);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_Commission_DtlsType();
    }

    public void setMaterial_Price(com.kcdata.abe.bapi.util.Zapi_Matl_PriceType_List Material_Price) {
        baseTypeData().setElementValue(13, Material_Price);
    }

    public void setCustomername(java.lang.String Customername) {
        baseTypeData().setElementValue(3, Customername);
    }

    public java.math.BigDecimal getDepositdue() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(7);
    }

    public java.lang.String getCustomername() {
        return (java.lang.String)baseTypeData().getElementValueAsString(3);
    }

    public MetaData metadataY_Bapi_Pri_Breakdown_Output() {
        return metadata;
    }

    public void setDetailprices(com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailType_List Detailprices) {
        baseTypeData().setElementValue(15, Detailprices);
    }

    public void setCustomername2(java.lang.String Customername2) {
        baseTypeData().setElementValue(4, Customername2);
    }

    public java.lang.String getCity() {
        return (java.lang.String)baseTypeData().getElementValueAsString(2);
    }

    public com.kcdata.abe.bapi.util.Zapi_Commission_DtlsType_List get_as_listCommissiondtls() {
        return (com.kcdata.abe.bapi.util.Zapi_Commission_DtlsType_List)baseTypeData().getElementValue(16);
    }

    public java.lang.String getCustomername2() {
        return (java.lang.String)baseTypeData().getElementValueAsString(4);
    }

    public java.lang.String getHousenumberstreet() {
        return (java.lang.String)baseTypeData().getElementValueAsString(9);
    }

    public void setHousenumberstreet(java.lang.String Housenumberstreet) {
        baseTypeData().setElementValue(9, Housenumberstreet);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Bapi_Pri_Breakdown_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Bapi_Pri_Breakdown_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getHeaderprices() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(14);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getReturn() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(12);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getPostalcode() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(10);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getDuration() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(8);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCommissiondtls() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(16);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getDetailprices() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(15);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCustomernumber() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getBookingdate() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getDepositdue() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(7);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCustomername() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getMaterial_Price() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(13);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getBookingstatus() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getRegionstate() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(11);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getDeparturedate() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(6);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCity() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCustomername2() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getHousenumberstreet() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(9);
        }
    
    }

}
