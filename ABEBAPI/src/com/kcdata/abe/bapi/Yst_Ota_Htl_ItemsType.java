package com.kcdata.abe.bapi;
public class Yst_Ota_Htl_ItemsType extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1396186757499L) ;

    private  Yst_Ota_Htl_ItemsType.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.XSDL_COMPLEX_TYPE, "urn:sap-com:document:sap:rfc:functions", "YST_OTA_HTL_ITEMS", 93, 0, com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "YST_OTA_HTL_ITEMS", 1994, 3860, -1, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_OTA_HTL_ITEMS\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">OTA Hotel Items</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>1994</ifr:internalLength1><ifr:internalLength2>3860</ifr:internalLength2></ifr:definition></ifr:container></s0:type>");
        descriptorSetElementProperties(descriptor, 0, "ITEM_RPH", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Item_Rph", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "3"}}, "ITEM_RPH", 0, 0, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ITEM_RPH\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Item RPH</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>0</ifr:offset1><ifr:offset2>0</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YITEM_RPH\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 1, "ROOMTYPECODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Roomtypecode", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "20"}}, "ROOMTYPECODE", 3, 6, -1, 20, 40, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ROOMTYPECODE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Room Type Code</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>3</ifr:offset1><ifr:offset2>6</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YROOM_TYPE_CODE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>20</ifr:length><ifr:internalLength1>20</ifr:internalLength1><ifr:internalLength2>40</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>20</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 2, "ROOM_TYPE_DESC", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Room_Type_Desc", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "100"}}, "ROOM_TYPE_DESC", 23, 46, -1, 100, 200, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ROOM_TYPE_DESC\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Room Type Description</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>23</ifr:offset1><ifr:offset2>46</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZROOMTYPDESC\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>100</ifr:length><ifr:internalLength1>100</ifr:internalLength1><ifr:internalLength2>200</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>100</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 3, "RATEPLANCODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Rateplancode", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "20"}}, "RATEPLANCODE", 123, 246, -1, 20, 40, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"RATEPLANCODE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Rate Plan Code</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>123</ifr:offset1><ifr:offset2>246</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YRATE_PLAN_CODE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>20</ifr:length><ifr:internalLength1>20</ifr:internalLength1><ifr:internalLength2>40</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>20</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 4, "RATEINDICATOR", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Rateindicator", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "25"}}, "RATEINDICATOR", 143, 286, -1, 25, 50, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"RATEINDICATOR\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Rate Indicator</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>143</ifr:offset1><ifr:offset2>286</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YRATEINDICATOR\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>25</ifr:length><ifr:internalLength1>25</ifr:internalLength1><ifr:internalLength2>50</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>25</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 5, "CORPINFO_CODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Corpinfo_Code", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "30"}}, "CORPINFO_CODE", 168, 336, -1, 30, 60, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CORPINFO_CODE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Company identification for room reservation</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>168</ifr:offset1><ifr:offset2>336</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"HOTEL_CORPORATE_ID\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>30</ifr:length><ifr:internalLength1>30</ifr:internalLength1><ifr:internalLength2>60</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>30</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 6, "GUARANTEE_TYPE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Guarantee_Type", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "40"}}, "GUARANTEE_TYPE", 198, 396, -1, 40, 80, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"GUARANTEE_TYPE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Guarantee for room reservation at booking</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>198</ifr:offset1><ifr:offset2>396</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"HOTEL_GUARANTEE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>40</ifr:length><ifr:internalLength1>40</ifr:internalLength1><ifr:internalLength2>80</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>40</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 7, "GUARANTEE_METHOD", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Guarantee_Method", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "25"}}, "GUARANTEE_METHOD", 238, 476, -1, 25, 50, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"GUARANTEE_METHOD\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Guarantee Method</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>238</ifr:offset1><ifr:offset2>476</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YGUARANTEE_METHOD\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>true</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>25</ifr:length><ifr:internalLength1>25</ifr:internalLength1><ifr:internalLength2>50</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>25</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 8, "GUARANTEE_REQ", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Guarantee_Req", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "5"}}, "GUARANTEE_REQ", 263, 526, -1, 5, 10, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"GUARANTEE_REQ\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Guarantee Require</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>263</ifr:offset1><ifr:offset2>526</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZGUARANTEE_REQ\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>5</ifr:length><ifr:internalLength1>5</ifr:internalLength1><ifr:internalLength2>10</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>5</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 9, "RATE_PLAN_CATG", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Rate_Plan_Catg", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "9"}}, "RATE_PLAN_CATG", 268, 536, -1, 9, 18, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"RATE_PLAN_CATG\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Rate Plan Category ( Material Group )</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>268</ifr:offset1><ifr:offset2>536</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YRATE_PLAN_CATG\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>9</ifr:length><ifr:internalLength1>9</ifr:internalLength1><ifr:internalLength2>18</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>9</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 10, "RATE_PLAN_ID", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Rate_Plan_Id", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "RATE_PLAN_ID", 277, 554, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"RATE_PLAN_ID\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Rate Plan ID C-Charter/S-Sked/L-Land Only</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>277</ifr:offset1><ifr:offset2>554</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YRATE_PLAN_ID\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>true</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 11, "ARR_DATE", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:date", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Arr_Date", java.sql.Date.class, null, new java.lang.String[][]{}, "ARR_DATE", 278, 556, -1, 8, 16, -1, com.sap.mw.jco.JCO.TYPE_DATE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ARR_DATE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Arrival Date Hotel</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>278</ifr:offset1><ifr:offset2>556</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"HOTEL_DATE_ARR\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>DATS</ifr:type><ifr:abapType>D</ifr:abapType><ifr:length>8</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>16</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 12, "DEP_DATE", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:date", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Dep_Date", java.sql.Date.class, null, new java.lang.String[][]{}, "DEP_DATE", 286, 572, -1, 8, 16, -1, com.sap.mw.jco.JCO.TYPE_DATE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"DEP_DATE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Departure Date Hotel</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>286</ifr:offset1><ifr:offset2>572</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"HOTEL_DATE_DEP\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>DATS</ifr:type><ifr:abapType>D</ifr:abapType><ifr:length>8</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>16</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 13, "ORIGIN_LOCATION", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Origin_Location", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "3"}}, "ORIGIN_LOCATION", 294, 588, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ORIGIN_LOCATION\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Name of the Origin (3 Char ID for Origin)</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>294</ifr:offset1><ifr:offset2>588</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZORIGIN\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 14, "HOTEL_CITY_CODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Hotel_City_Code", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "3"}}, "HOTEL_CITY_CODE", 297, 594, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"HOTEL_CITY_CODE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Hotel Location</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>297</ifr:offset1><ifr:offset2>594</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"HOTEL_SLOCATION\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 15, "HOTEL_CHAIN", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Hotel_Chain", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "30"}}, "HOTEL_CHAIN", 300, 600, -1, 30, 60, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"HOTEL_CHAIN\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Hotel Chain</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>300</ifr:offset1><ifr:offset2>600</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZHOTEL_CHAIN\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>30</ifr:length><ifr:internalLength1>30</ifr:internalLength1><ifr:internalLength2>60</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>30</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 16, "FREE_NIGHTS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Free_Nights", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "FREE_NIGHTS", 330, 660, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"FREE_NIGHTS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Free Nights</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>330</ifr:offset1><ifr:offset2>660</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YFREENIGHTS\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 17, "TAXES", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Taxes", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "17"}, {"fractionDigits", "2"}}, "TAXES", 332, 664, -1, 9, 9, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"TAXES\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Tax</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>CURRENCY</ifr:referenceField><ifr:referenceTable>YST_OTA_HTL_ITEMS</ifr:referenceTable><ifr:offset1>332</ifr:offset1><ifr:offset2>664</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"BKK_TAX\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>true</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>17</ifr:length><ifr:internalLength1>9</ifr:internalLength1><ifr:internalLength2>9</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>23</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 18, "PROMO_SAVINGS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Promo_Savings", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "15"}, {"fractionDigits", "2"}}, "PROMO_SAVINGS", 341, 673, -1, 8, 8, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"PROMO_SAVINGS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Promotion Savings Amount</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>CURRENCY</ifr:referenceField><ifr:referenceTable>YST_OTA_HTL_ITEMS</ifr:referenceTable><ifr:offset1>341</ifr:offset1><ifr:offset2>673</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YPROMO_SAVINGS\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>true</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>15</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>21</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 19, "SAVINGS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Savings", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "15"}, {"fractionDigits", "2"}}, "SAVINGS", 349, 681, -1, 8, 8, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"SAVINGS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Savings</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>CURRENCY</ifr:referenceField><ifr:referenceTable>YST_OTA_HTL_ITEMS</ifr:referenceTable><ifr:offset1>349</ifr:offset1><ifr:offset2>681</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZSAVING\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>true</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>15</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>21</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 20, "TOTAL", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Total", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "17"}, {"fractionDigits", "2"}}, "TOTAL", 357, 689, -1, 9, 9, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"TOTAL\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Amount</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>CURRENCY</ifr:referenceField><ifr:referenceTable>YST_OTA_HTL_ITEMS</ifr:referenceTable><ifr:offset1>357</ifr:offset1><ifr:offset2>689</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"BKK_AMOUNT\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>true</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>17</ifr:length><ifr:internalLength1>9</ifr:internalLength1><ifr:internalLength2>9</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>23</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 21, "CURRENCY", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Currency", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "5"}}, "CURRENCY", 366, 698, -1, 5, 10, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CURRENCY\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Currency</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>366</ifr:offset1><ifr:offset2>698</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"HOTEL_CURRENCY\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CUKY</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>5</ifr:length><ifr:internalLength1>5</ifr:internalLength1><ifr:internalLength2>10</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>5</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 22, "PAX_ALLOC_RPH", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Pax_Alloc_Rph", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "300"}}, "PAX_ALLOC_RPH", 371, 708, -1, 300, 600, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"PAX_ALLOC_RPH\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Extended Pax Allocation RPH</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>371</ifr:offset1><ifr:offset2>708</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YPAX_ALLOC_RPH_EXD\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>300</ifr:length><ifr:internalLength1>300</ifr:internalLength1><ifr:internalLength2>600</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>200</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 23, "HOTEL_NAME", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Hotel_Name", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "128"}}, "HOTEL_NAME", 671, 1308, -1, 128, 256, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"HOTEL_NAME\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Name of Hotel</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>671</ifr:offset1><ifr:offset2>1308</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YHOTEL_NAME\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>128</ifr:length><ifr:internalLength1>128</ifr:internalLength1><ifr:internalLength2>256</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>128</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 24, "RATING", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Rating", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "2"}}, "RATING", 799, 1564, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"RATING\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Apple rating of hotel</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>799</ifr:offset1><ifr:offset2>1564</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZAPPLE_RATING\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 25, "RESORT_AREA", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Resort_Area", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "30"}}, "RESORT_AREA", 801, 1568, -1, 30, 60, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"RESORT_AREA\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Hotel location</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>801</ifr:offset1><ifr:offset2>1568</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"HOTEL_LOCATION\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>30</ifr:length><ifr:internalLength1>30</ifr:internalLength1><ifr:internalLength2>60</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>30</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 26, "DURATION", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Duration", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "DURATION", 831, 1628, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"DURATION\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Duration .</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>831</ifr:offset1><ifr:offset2>1628</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZDURATION\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 27, "HOTEL_CODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Hotel_Code", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "10"}}, "HOTEL_CODE", 833, 1632, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"HOTEL_CODE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Number of a Manufacturer</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>833</ifr:offset1><ifr:offset2>1632</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"MFRNR\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength><ifr:conversionExit>ALPHA</ifr:conversionExit></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 28, "PRICE_CHANGE_IND", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Price_Change_Ind", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "1"}}, "PRICE_CHANGE_IND", 843, 1652, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"PRICE_CHANGE_IND\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Price Change Indicator</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>843</ifr:offset1><ifr:offset2>1652</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YPRICE_CHANGE_IND\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>true</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 29, "COMMISSION", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Commission", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "15"}, {"fractionDigits", "2"}}, "COMMISSION", 844, 1654, -1, 8, 8, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"COMMISSION\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Commission Amount</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>CURRENCY</ifr:referenceField><ifr:referenceTable>YST_OTA_HTL_ITEMS</ifr:referenceTable><ifr:offset1>844</ifr:offset1><ifr:offset2>1654</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YCOMMISSION\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>true</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>15</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>21</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 30, "COMMISSION_PRCT", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Commission_Prct", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "5"}, {"fractionDigits", "2"}}, "COMMISSION_PRCT", 852, 1662, -1, 3, 3, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"COMMISSION_PRCT\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Commission Percent</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>852</ifr:offset1><ifr:offset2>1662</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YCOMMISSION_PRCT\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>DEC</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>5</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>3</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>6</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 31, "FLT_ITEM_RPH", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Flt_Item_Rph", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "50"}}, "FLT_ITEM_RPH", 855, 1666, -1, 50, 100, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"FLT_ITEM_RPH\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Package Allocation Item RPH</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>855</ifr:offset1><ifr:offset2>1666</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YPKG_ITEM_RPH\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>50</ifr:length><ifr:internalLength1>50</ifr:internalLength1><ifr:internalLength2>100</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>50</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 32, "VEH_ITEM_RPH", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Veh_Item_Rph", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "50"}}, "VEH_ITEM_RPH", 905, 1766, -1, 50, 100, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"VEH_ITEM_RPH\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Package Allocation Item RPH</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>905</ifr:offset1><ifr:offset2>1766</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YPKG_ITEM_RPH\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>50</ifr:length><ifr:internalLength1>50</ifr:internalLength1><ifr:internalLength2>100</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>50</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 33, "TRANSFER_ALLOC_RPH", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Transfer_Alloc_Rph", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "300"}}, "TRANSFER_ALLOC_RPH", 955, 1866, -1, 300, 600, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"TRANSFER_ALLOC_RPH\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Extended Pax Allocation RPH</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>955</ifr:offset1><ifr:offset2>1866</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YPAX_ALLOC_RPH_EXD\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>300</ifr:length><ifr:internalLength1>300</ifr:internalLength1><ifr:internalLength2>600</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>200</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 34, "PKG_TOTAL", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Pkg_Total", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "15"}, {"fractionDigits", "2"}}, "PKG_TOTAL", 1255, 2466, -1, 8, 8, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"PKG_TOTAL\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Total Amount</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>CURRENCY</ifr:referenceField><ifr:referenceTable>YST_OTA_HTL_ITEMS</ifr:referenceTable><ifr:offset1>1255</ifr:offset1><ifr:offset2>2466</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YTOTAL\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>true</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>15</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>21</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 35, "NO_ADULTS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "No_Adults", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "NO_ADULTS", 1263, 2474, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"NO_ADULTS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Total Number of Adults in the tour .</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1263</ifr:offset1><ifr:offset2>2474</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZADULTS\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 36, "CHILD1_AGE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Child1_Age", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "CHILD1_AGE", 1265, 2478, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CHILD1_AGE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Age in years</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1265</ifr:offset1><ifr:offset2>2478</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"AGEJJ\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 37, "CHILD2_AGE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Child2_Age", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "CHILD2_AGE", 1267, 2482, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CHILD2_AGE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Age in years</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1267</ifr:offset1><ifr:offset2>2482</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"AGEJJ\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 38, "CHILD3_AGE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Child3_Age", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "CHILD3_AGE", 1269, 2486, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CHILD3_AGE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Age in years</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1269</ifr:offset1><ifr:offset2>2486</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"AGEJJ\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 39, "CHILD4_AGE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Child4_Age", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "CHILD4_AGE", 1271, 2490, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CHILD4_AGE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Age in years</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1271</ifr:offset1><ifr:offset2>2490</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"AGEJJ\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 40, "CHILD5_AGE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Child5_Age", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "CHILD5_AGE", 1273, 2494, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CHILD5_AGE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Age in years</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1273</ifr:offset1><ifr:offset2>2494</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"AGEJJ\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 41, "CHILD6_AGE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Child6_Age", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "CHILD6_AGE", 1275, 2498, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CHILD6_AGE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Age in years</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1275</ifr:offset1><ifr:offset2>2498</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"AGEJJ\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 42, "CHILD1_TYPE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Child1_Type", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "CHILD1_TYPE", 1277, 2502, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CHILD1_TYPE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Passenger Type ( A/S/C/I)</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1277</ifr:offset1><ifr:offset2>2502</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YPAXTYPE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 43, "CHILD2_TYPE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Child2_Type", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "CHILD2_TYPE", 1278, 2504, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CHILD2_TYPE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Passenger Type ( A/S/C/I)</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1278</ifr:offset1><ifr:offset2>2504</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YPAXTYPE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 44, "CHILD3_TYPE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Child3_Type", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "CHILD3_TYPE", 1279, 2506, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CHILD3_TYPE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Passenger Type ( A/S/C/I)</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1279</ifr:offset1><ifr:offset2>2506</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YPAXTYPE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 45, "CHILD4_TYPE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Child4_Type", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "CHILD4_TYPE", 1280, 2508, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CHILD4_TYPE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Passenger Type ( A/S/C/I)</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1280</ifr:offset1><ifr:offset2>2508</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YPAXTYPE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 46, "CHILD5_TYPE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Child5_Type", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "CHILD5_TYPE", 1281, 2510, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CHILD5_TYPE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Passenger Type ( A/S/C/I)</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1281</ifr:offset1><ifr:offset2>2510</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YPAXTYPE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 47, "CHILD6_TYPE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Child6_Type", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "CHILD6_TYPE", 1282, 2512, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CHILD6_TYPE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Passenger Type ( A/S/C/I)</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1282</ifr:offset1><ifr:offset2>2512</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YPAXTYPE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 48, "NO_CHILD", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "No_Child", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "NO_CHILD", 1283, 2514, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"NO_CHILD\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Total No. Of Children ( C )</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1283</ifr:offset1><ifr:offset2>2514</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YNOOFCHILD\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 49, "NO_JUNIORS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "No_Juniors", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "NO_JUNIORS", 1285, 2518, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"NO_JUNIORS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Total No. Of Juniors ( D )</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1285</ifr:offset1><ifr:offset2>2518</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YNOOFJUNIORS\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 50, "NO_MINORS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "No_Minors", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "NO_MINORS", 1287, 2522, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"NO_MINORS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Total No. Of Minors ( E )</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1287</ifr:offset1><ifr:offset2>2522</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YNOOFMINORS\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 51, "NO_SENIORS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "No_Seniors", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "NO_SENIORS", 1289, 2526, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"NO_SENIORS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Total Number of Seniors in a Room.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1289</ifr:offset1><ifr:offset2>2526</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZSENIOR_R\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 52, "NO_INFANTS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "No_Infants", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "NO_INFANTS", 1291, 2530, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"NO_INFANTS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Total No. Of Infants ( I )</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1291</ifr:offset1><ifr:offset2>2530</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YNOOFINFANTS\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 53, "NO_LAPCHILD", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "No_Lapchild", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "NO_LAPCHILD", 1293, 2534, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"NO_LAPCHILD\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Total No. Of Lap Child ( L )</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1293</ifr:offset1><ifr:offset2>2534</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YNOOFLAPCHILD\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 54, "ADULT_BASE_PRICE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Adult_Base_Price", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "15"}, {"fractionDigits", "2"}}, "ADULT_BASE_PRICE", 1295, 2538, -1, 8, 8, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ADULT_BASE_PRICE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Price Per Adult</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>CURRENCY</ifr:referenceField><ifr:referenceTable>YST_OTA_HTL_ITEMS</ifr:referenceTable><ifr:offset1>1295</ifr:offset1><ifr:offset2>2538</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YADULT_PRICE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>true</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>15</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>21</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 55, "CHILD_BASE_PRICE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Child_Base_Price", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "15"}, {"fractionDigits", "2"}}, "CHILD_BASE_PRICE", 1303, 2546, -1, 8, 8, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CHILD_BASE_PRICE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Price Per Child</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>CURRENCY</ifr:referenceField><ifr:referenceTable>YST_OTA_HTL_ITEMS</ifr:referenceTable><ifr:offset1>1303</ifr:offset1><ifr:offset2>2546</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YCHILD_PRICE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>true</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>15</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>21</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 56, "SENIOR_BASE_PRICE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Senior_Base_Price", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "15"}, {"fractionDigits", "2"}}, "SENIOR_BASE_PRICE", 1311, 2554, -1, 8, 8, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"SENIOR_BASE_PRICE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Price Per Senior</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>CURRENCY</ifr:referenceField><ifr:referenceTable>YST_OTA_HTL_ITEMS</ifr:referenceTable><ifr:offset1>1311</ifr:offset1><ifr:offset2>2554</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YSENIOR_PRICE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>true</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>15</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>21</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 57, "JUNIOR_BASE_PRICE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Junior_Base_Price", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "15"}, {"fractionDigits", "2"}}, "JUNIOR_BASE_PRICE", 1319, 2562, -1, 8, 8, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"JUNIOR_BASE_PRICE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Price Per Junior</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>CURRENCY</ifr:referenceField><ifr:referenceTable>YST_OTA_HTL_ITEMS</ifr:referenceTable><ifr:offset1>1319</ifr:offset1><ifr:offset2>2562</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YJUNIOR_PRICE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>true</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>15</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>21</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 58, "MINOR_BASE_PRICE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Minor_Base_Price", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "15"}, {"fractionDigits", "2"}}, "MINOR_BASE_PRICE", 1327, 2570, -1, 8, 8, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"MINOR_BASE_PRICE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Price Per Minor</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>CURRENCY</ifr:referenceField><ifr:referenceTable>YST_OTA_HTL_ITEMS</ifr:referenceTable><ifr:offset1>1327</ifr:offset1><ifr:offset2>2570</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YMINOR_PRICE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>true</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>15</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>21</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 59, "PER_ADULT_BASE_PRICE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Per_Adult_Base_Price", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "15"}, {"fractionDigits", "2"}}, "PER_ADULT_BASE_PRICE", 1335, 2578, -1, 8, 8, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"PER_ADULT_BASE_PRICE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Per Adult Base Price</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>CURRENCY</ifr:referenceField><ifr:referenceTable>YST_OTA_HTL_ITEMS</ifr:referenceTable><ifr:offset1>1335</ifr:offset1><ifr:offset2>2578</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YPER_ADULT_BASE_PRICE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>true</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>15</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>21</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 60, "POSNR", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Posnr", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "6"}}, "POSNR", 1343, 2586, -1, 6, 12, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"POSNR\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Item number of the SD document</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1343</ifr:offset1><ifr:offset2>2586</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"POSNR\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>6</ifr:length><ifr:internalLength1>6</ifr:internalLength1><ifr:internalLength2>12</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>6</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 61, "OLD_POSNR", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Old_Posnr", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "6"}}, "OLD_POSNR", 1349, 2598, -1, 6, 12, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"OLD_POSNR\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Item number of the SD document</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1349</ifr:offset1><ifr:offset2>2598</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"POSNR\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>6</ifr:length><ifr:internalLength1>6</ifr:internalLength1><ifr:internalLength2>12</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>6</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 62, "FLIGHT_REQ_TYPE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Flight_Req_Type", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "FLIGHT_REQ_TYPE", 1355, 2610, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"FLIGHT_REQ_TYPE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Flight Request Type C- Charter S-Sked</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1355</ifr:offset1><ifr:offset2>2610</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YFLIGHT_REQ_TYPE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 63, "PKG_HTL_NOCHANGE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Pkg_Htl_Nochange", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "PKG_HTL_NOCHANGE", 1356, 2612, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"PKG_HTL_NOCHANGE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Hotel changed in Package</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1356</ifr:offset1><ifr:offset2>2612</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YPKG_HTL_CHANGED\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 64, "GDS_HOTEL_CODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Gds_Hotel_Code", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "10"}}, "GDS_HOTEL_CODE", 1357, 2614, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"GDS_HOTEL_CODE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Hotel Code</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1357</ifr:offset1><ifr:offset2>2614</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YHTL_COD\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 65, "SOURCE_PARTNER", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Source_Partner", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "6"}}, "SOURCE_PARTNER", 1367, 2634, -1, 6, 12, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"SOURCE_PARTNER\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Source Partner code for booking process (HBSi)</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1367</ifr:offset1><ifr:offset2>2634</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YSOURCE_PARTNER\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>6</ifr:length><ifr:internalLength1>6</ifr:internalLength1><ifr:internalLength2>12</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>6</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 66, "SOURCE_PNRNO", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Source_Pnrno", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "32"}}, "SOURCE_PNRNO", 1373, 2646, -1, 32, 64, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"SOURCE_PNRNO\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">PNR number (32 length)</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1373</ifr:offset1><ifr:offset2>2646</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZPNRNO32\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>32</ifr:length><ifr:internalLength1>32</ifr:internalLength1><ifr:internalLength2>64</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>32</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 67, "HOTEL_CONFIRMNO", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Hotel_Confirmno", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "32"}}, "HOTEL_CONFIRMNO", 1405, 2710, -1, 32, 64, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"HOTEL_CONFIRMNO\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Confirmation Number</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1405</ifr:offset1><ifr:offset2>2710</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YCONFIRM\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>32</ifr:length><ifr:internalLength1>32</ifr:internalLength1><ifr:internalLength2>64</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>32</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 68, "SOURCE_ROOMTYPECODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Source_Roomtypecode", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "20"}}, "SOURCE_ROOMTYPECODE", 1437, 2774, -1, 20, 40, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"SOURCE_ROOMTYPECODE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Room Type Code</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1437</ifr:offset1><ifr:offset2>2774</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YROOM_TYPE_CODE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>20</ifr:length><ifr:internalLength1>20</ifr:internalLength1><ifr:internalLength2>40</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>20</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 69, "LINE1", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Line1", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "60"}}, "LINE1", 1457, 2814, -1, 60, 120, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"LINE1\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Street and house number of hotel</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1457</ifr:offset1><ifr:offset2>2814</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"HOTEL_STREET\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>60</ifr:length><ifr:internalLength1>60</ifr:internalLength1><ifr:internalLength2>120</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>60</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 70, "LINE2", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Line2", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "60"}}, "LINE2", 1517, 2934, -1, 60, 120, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"LINE2\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Street and house number of hotel</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1517</ifr:offset1><ifr:offset2>2934</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"HOTEL_STREET\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>60</ifr:length><ifr:internalLength1>60</ifr:internalLength1><ifr:internalLength2>120</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>60</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 71, "CITY", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "City", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "40"}}, "CITY", 1577, 3054, -1, 40, 80, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CITY\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">City</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>1577</ifr:offset1><ifr:offset2>3054</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"AD_CITY1\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>40</ifr:length><ifr:internalLength1>40</ifr:internalLength1><ifr:internalLength2>80</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>40</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 72, "STATECODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Statecode", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "3"}}, "STATECODE", 1617, 3134, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"STATECODE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Region (State, Province, County)</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1617</ifr:offset1><ifr:offset2>3134</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"REGIO\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 73, "POSTALCODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Postalcode", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "10"}}, "POSTALCODE", 1620, 3140, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"POSTALCODE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Postal Code</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>1620</ifr:offset1><ifr:offset2>3140</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"POST_CODE\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 74, "COUNTRYCODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Countrycode", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "3"}}, "COUNTRYCODE", 1630, 3160, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"COUNTRYCODE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Country Key</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1630</ifr:offset1><ifr:offset2>3160</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"LAND1\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 75, "PHONENUMBER", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Phonenumber", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "40"}}, "PHONENUMBER", 1633, 3166, -1, 40, 80, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"PHONENUMBER\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Telephone Number</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1633</ifr:offset1><ifr:offset2>3166</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"AP_PHONE_NUMBER\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>40</ifr:length><ifr:internalLength1>40</ifr:internalLength1><ifr:internalLength2>80</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>40</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 76, "EMAIL", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Email", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "25"}}, "EMAIL", 1673, 3246, -1, 25, 50, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"EMAIL\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">E-mail Address</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1673</ifr:offset1><ifr:offset2>3246</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZEMAIL\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>25</ifr:length><ifr:internalLength1>25</ifr:internalLength1><ifr:internalLength2>50</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>25</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 77, "RATEPLNDESC", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Rateplndesc", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "100"}}, "RATEPLNDESC", 1698, 3296, -1, 100, 200, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"RATEPLNDESC\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Rate Plan Description</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1698</ifr:offset1><ifr:offset2>3296</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZRATEPLNDESC\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>100</ifr:length><ifr:internalLength1>100</ifr:internalLength1><ifr:internalLength2>200</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>100</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 78, "MEALPLAN_CODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Mealplan_Code", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "3"}}, "MEALPLAN_CODE", 1798, 3496, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"MEALPLAN_CODE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Meal Plan Code.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1798</ifr:offset1><ifr:offset2>3496</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZMPCODE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 79, "MEALPLAN_DESC", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Mealplan_Desc", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "40"}}, "MEALPLAN_DESC", 1801, 3502, -1, 40, 80, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"MEALPLAN_DESC\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Meal Plans.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1801</ifr:offset1><ifr:offset2>3502</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZMEALP\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>40</ifr:length><ifr:internalLength1>40</ifr:internalLength1><ifr:internalLength2>80</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>40</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 80, "TOTAL_HOTEL_COST", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Total_Hotel_Cost", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "15"}, {"fractionDigits", "2"}}, "TOTAL_HOTEL_COST", 1841, 3582, -1, 8, 8, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"TOTAL_HOTEL_COST\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Total Hotel Room Cost</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>CURRENCY</ifr:referenceField><ifr:referenceTable>YST_OTA_HTL_ITEMS</ifr:referenceTable><ifr:offset1>1841</ifr:offset1><ifr:offset2>3582</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YTOT_COST\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>true</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>15</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>21</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 81, "TOTAL_TRANSFER_COST", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Total_Transfer_Cost", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "15"}, {"fractionDigits", "2"}}, "TOTAL_TRANSFER_COST", 1849, 3590, -1, 8, 8, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"TOTAL_TRANSFER_COST\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Total Transfer Cost</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>CURRENCY</ifr:referenceField><ifr:referenceTable>YST_OTA_HTL_ITEMS</ifr:referenceTable><ifr:offset1>1849</ifr:offset1><ifr:offset2>3590</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YTOTAL_TRANSFER_COST\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>true</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>15</ifr:length><ifr:internalLength1>8</ifr:internalLength1><ifr:internalLength2>8</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>21</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 82, "CANCEL_CUTOFFDAYS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Cancel_Cutoffdays", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "CANCEL_CUTOFFDAYS", 1857, 3598, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CANCEL_CUTOFFDAYS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Cancellation cut off duration</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1857</ifr:offset1><ifr:offset2>3598</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZCANCCUTOFF\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 83, "CANCEL_MIN_DURA", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Cancel_Min_Dura", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "CANCEL_MIN_DURA", 1859, 3602, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CANCEL_MIN_DURA\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Minimum duration for cancellation</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1859</ifr:offset1><ifr:offset2>3602</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZMINDURCANC\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 84, "CANCEL_MIN_DAYS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Cancel_Min_Days", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "CANCEL_MIN_DAYS", 1861, 3606, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CANCEL_MIN_DAYS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Minimum days for cancellation</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1861</ifr:offset1><ifr:offset2>3606</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZMINCANCDAYS\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 85, "CANCEL_MIN_FEE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Cancel_Min_Fee", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "8"}, {"fractionDigits", "2"}}, "CANCEL_MIN_FEE", 1863, 3610, -1, 5, 5, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CANCEL_MIN_FEE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Minimum cancellation fee</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>CURRENCY</ifr:referenceField><ifr:referenceTable>YST_OTA_HTL_ITEMS</ifr:referenceTable><ifr:offset1>1863</ifr:offset1><ifr:offset2>3610</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZMINCANCFEE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>8</ifr:length><ifr:internalLength1>5</ifr:internalLength1><ifr:internalLength2>5</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 86, "CANCEL_MAX_DURA", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Cancel_Max_Dura", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "CANCEL_MAX_DURA", 1868, 3616, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CANCEL_MAX_DURA\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Maximum duration for cancellation</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1868</ifr:offset1><ifr:offset2>3616</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZMAXDURCANC\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 87, "CANCEL_MAX_DAYS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Cancel_Max_Days", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "CANCEL_MAX_DAYS", 1870, 3620, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CANCEL_MAX_DAYS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Maximum days for cancellation</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1870</ifr:offset1><ifr:offset2>3620</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZMAXCANCDAYS\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 88, "CANCEL_MAX_FEE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Cancel_Max_Fee", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "8"}, {"fractionDigits", "2"}}, "CANCEL_MAX_FEE", 1872, 3624, -1, 5, 5, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CANCEL_MAX_FEE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Maximum Cancellation fee</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>CURRENCY</ifr:referenceField><ifr:referenceTable>YST_OTA_HTL_ITEMS</ifr:referenceTable><ifr:offset1>1872</ifr:offset1><ifr:offset2>3624</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZMAXCANCFEE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>8</ifr:length><ifr:internalLength1>5</ifr:internalLength1><ifr:internalLength2>5</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 89, "CANCEL_MID_DAYS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Cancel_Mid_Days", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "CANCEL_MID_DAYS", 1877, 3630, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CANCEL_MID_DAYS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">In between days for cancellation</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1877</ifr:offset1><ifr:offset2>3630</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZMIDCANCDAYS\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 90, "CANCEL_MID_FEE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Cancel_Mid_Fee", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "8"}, {"fractionDigits", "2"}}, "CANCEL_MID_FEE", 1879, 3634, -1, 5, 5, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CANCEL_MID_FEE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Maximum Cancellation fee</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>CURRENCY</ifr:referenceField><ifr:referenceTable>YST_OTA_HTL_ITEMS</ifr:referenceTable><ifr:offset1>1879</ifr:offset1><ifr:offset2>3634</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZMAXCANCFEE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>8</ifr:length><ifr:internalLength1>5</ifr:internalLength1><ifr:internalLength2>5</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 91, "CANCEL_POLICYCODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Cancel_Policycode", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "10"}}, "CANCEL_POLICYCODE", 1884, 3640, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CANCEL_POLICYCODE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Cancel Policy Code</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1884</ifr:offset1><ifr:offset2>3640</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZCANCCODE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 92, "CANCEL_POLICYDESC", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Cancel_Policydesc", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "100"}}, "CANCEL_POLICYDESC", 1894, 3660, -1, 100, 200, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CANCEL_POLICYDESC\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Cancel Policy Code Description</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1894</ifr:offset1><ifr:offset2>3660</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZCANCCODEDESC\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>100</ifr:length><ifr:internalLength1>100</ifr:internalLength1><ifr:internalLength2>200</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>100</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        staticDescriptor = descriptor;
    }
    public  Yst_Ota_Htl_ItemsType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Yst_Ota_Htl_ItemsType (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public java.lang.String getSource_Partner() {
        return (java.lang.String)baseTypeData().getElementValueAsString(65);
    }

    public java.lang.String getRating() {
        return (java.lang.String)baseTypeData().getElementValueAsString(24);
    }

    public void setRoom_Type_Desc(java.lang.String Room_Type_Desc) {
        baseTypeData().setElementValue(2, Room_Type_Desc);
    }

    public void setRate_Plan_Id(java.lang.String Rate_Plan_Id) {
        baseTypeData().setElementValue(10, Rate_Plan_Id);
    }

    public java.lang.String getMealplan_Desc() {
        return (java.lang.String)baseTypeData().getElementValueAsString(79);
    }

    public java.lang.String getChild2_Age() {
        return (java.lang.String)baseTypeData().getElementValueAsString(37);
    }

    public void setCancel_Min_Fee(java.math.BigDecimal Cancel_Min_Fee) {
        baseTypeData().setElementValue(85, Cancel_Min_Fee);
    }

    public void setNo_Juniors(java.lang.String No_Juniors) {
        baseTypeData().setElementValue(49, No_Juniors);
    }

    public void setTransfer_Alloc_Rph(java.lang.String Transfer_Alloc_Rph) {
        baseTypeData().setElementValue(33, Transfer_Alloc_Rph);
    }

    public java.lang.String getLine1() {
        return (java.lang.String)baseTypeData().getElementValueAsString(69);
    }

    public void setOrigin_Location(java.lang.String Origin_Location) {
        baseTypeData().setElementValue(13, Origin_Location);
    }

    public java.lang.String getEmail() {
        return (java.lang.String)baseTypeData().getElementValueAsString(76);
    }

    public void setPkg_Total(java.math.BigDecimal Pkg_Total) {
        baseTypeData().setElementValue(34, Pkg_Total);
    }

    public java.math.BigDecimal getSavings() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(19);
    }

    public java.lang.String getPosnr() {
        return (java.lang.String)baseTypeData().getElementValueAsString(60);
    }

    public java.sql.Date getArr_Date() {
        return (java.sql.Date)baseTypeData().getElementValueAsDate(11);
    }

    public java.lang.String getHotel_Chain() {
        return (java.lang.String)baseTypeData().getElementValueAsString(15);
    }

    public void setSource_Roomtypecode(java.lang.String Source_Roomtypecode) {
        baseTypeData().setElementValue(68, Source_Roomtypecode);
    }

    public java.lang.String getCorpinfo_Code() {
        return (java.lang.String)baseTypeData().getElementValueAsString(5);
    }

    public void setMinor_Base_Price(java.math.BigDecimal Minor_Base_Price) {
        baseTypeData().setElementValue(58, Minor_Base_Price);
    }

    public void setChild2_Type(java.lang.String Child2_Type) {
        baseTypeData().setElementValue(43, Child2_Type);
    }

    public void setNo_Child(java.lang.String No_Child) {
        baseTypeData().setElementValue(48, No_Child);
    }

    public void setChild6_Type(java.lang.String Child6_Type) {
        baseTypeData().setElementValue(47, Child6_Type);
    }

    public void setAdult_Base_Price(java.math.BigDecimal Adult_Base_Price) {
        baseTypeData().setElementValue(54, Adult_Base_Price);
    }

    public void setHotel_Code(java.lang.String Hotel_Code) {
        baseTypeData().setElementValue(27, Hotel_Code);
    }

    public void setChild4_Age(java.lang.String Child4_Age) {
        baseTypeData().setElementValue(39, Child4_Age);
    }

    public java.lang.String getPax_Alloc_Rph() {
        return (java.lang.String)baseTypeData().getElementValueAsString(22);
    }

    public void setNo_Adults(java.lang.String No_Adults) {
        baseTypeData().setElementValue(35, No_Adults);
    }

    public void setCancel_Mid_Days(java.lang.String Cancel_Mid_Days) {
        baseTypeData().setElementValue(89, Cancel_Mid_Days);
    }

    public void setArr_Date(java.sql.Date Arr_Date) {
        baseTypeData().setElementValue(11, Arr_Date);
    }

    public java.lang.String getChild4_Type() {
        return (java.lang.String)baseTypeData().getElementValueAsString(45);
    }

    public java.lang.String getMealplan_Code() {
        return (java.lang.String)baseTypeData().getElementValueAsString(78);
    }

    public java.lang.String getLine2() {
        return (java.lang.String)baseTypeData().getElementValueAsString(70);
    }

    public java.lang.String getRoom_Type_Desc() {
        return (java.lang.String)baseTypeData().getElementValueAsString(2);
    }

    public java.lang.String getRate_Plan_Id() {
        return (java.lang.String)baseTypeData().getElementValueAsString(10);
    }

    public void setFree_Nights(java.lang.String Free_Nights) {
        baseTypeData().setElementValue(16, Free_Nights);
    }

    public java.lang.String getResort_Area() {
        return (java.lang.String)baseTypeData().getElementValueAsString(25);
    }

    public java.lang.String getNo_Juniors() {
        return (java.lang.String)baseTypeData().getElementValueAsString(49);
    }

    public java.lang.String getTransfer_Alloc_Rph() {
        return (java.lang.String)baseTypeData().getElementValueAsString(33);
    }

    public void setVeh_Item_Rph(java.lang.String Veh_Item_Rph) {
        baseTypeData().setElementValue(32, Veh_Item_Rph);
    }

    public java.math.BigDecimal getCancel_Mid_Fee() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(90);
    }

    public void setGuarantee_Req(java.lang.String Guarantee_Req) {
        baseTypeData().setElementValue(8, Guarantee_Req);
    }

    public void setCancel_Max_Fee(java.math.BigDecimal Cancel_Max_Fee) {
        baseTypeData().setElementValue(88, Cancel_Max_Fee);
    }

    public java.lang.String getCancel_Min_Dura() {
        return (java.lang.String)baseTypeData().getElementValueAsString(83);
    }

    public void setCancel_Max_Dura(java.lang.String Cancel_Max_Dura) {
        baseTypeData().setElementValue(86, Cancel_Max_Dura);
    }

    public java.sql.Date getDep_Date() {
        return (java.sql.Date)baseTypeData().getElementValueAsDate(12);
    }

    public java.lang.String getNo_Child() {
        return (java.lang.String)baseTypeData().getElementValueAsString(48);
    }

    public java.lang.String getCancel_Min_Days() {
        return (java.lang.String)baseTypeData().getElementValueAsString(84);
    }

    public void setHotel_Name(java.lang.String Hotel_Name) {
        baseTypeData().setElementValue(23, Hotel_Name);
    }

    public void setChild1_Age(java.lang.String Child1_Age) {
        baseTypeData().setElementValue(36, Child1_Age);
    }

    public void setDuration(java.lang.String Duration) {
        baseTypeData().setElementValue(26, Duration);
    }

    public void setCancel_Max_Days(java.lang.String Cancel_Max_Days) {
        baseTypeData().setElementValue(87, Cancel_Max_Days);
    }

    public void setHotel_Confirmno(java.lang.String Hotel_Confirmno) {
        baseTypeData().setElementValue(67, Hotel_Confirmno);
    }

    public void setGuarantee_Type(java.lang.String Guarantee_Type) {
        baseTypeData().setElementValue(6, Guarantee_Type);
    }

    public java.lang.String getHotel_Code() {
        return (java.lang.String)baseTypeData().getElementValueAsString(27);
    }

    public java.lang.String getChild4_Age() {
        return (java.lang.String)baseTypeData().getElementValueAsString(39);
    }

    public java.lang.String getOld_Posnr() {
        return (java.lang.String)baseTypeData().getElementValueAsString(61);
    }

    public java.math.BigDecimal getTotal_Hotel_Cost() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(80);
    }

    public java.lang.String getNo_Lapchild() {
        return (java.lang.String)baseTypeData().getElementValueAsString(53);
    }

    public void setCity(java.lang.String City) {
        baseTypeData().setElementValue(71, City);
    }

    public void setRateindicator(java.lang.String Rateindicator) {
        baseTypeData().setElementValue(4, Rateindicator);
    }

    public void setJunior_Base_Price(java.math.BigDecimal Junior_Base_Price) {
        baseTypeData().setElementValue(57, Junior_Base_Price);
    }

    public java.lang.String getPhonenumber() {
        return (java.lang.String)baseTypeData().getElementValueAsString(75);
    }

    public java.math.BigDecimal getPkg_Total() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(34);
    }

    public void setChild3_Type(java.lang.String Child3_Type) {
        baseTypeData().setElementValue(44, Child3_Type);
    }

    public void setCommission_Prct(java.math.BigDecimal Commission_Prct) {
        baseTypeData().setElementValue(30, Commission_Prct);
    }

    public java.lang.String getVeh_Item_Rph() {
        return (java.lang.String)baseTypeData().getElementValueAsString(32);
    }

    public void setPer_Adult_Base_Price(java.math.BigDecimal Per_Adult_Base_Price) {
        baseTypeData().setElementValue(59, Per_Adult_Base_Price);
    }

    public void setStatecode(java.lang.String Statecode) {
        baseTypeData().setElementValue(72, Statecode);
    }

    public void setChild6_Age(java.lang.String Child6_Age) {
        baseTypeData().setElementValue(41, Child6_Age);
    }

    public void setNo_Minors(java.lang.String No_Minors) {
        baseTypeData().setElementValue(50, No_Minors);
    }

    public java.lang.String getCancel_Policydesc() {
        return (java.lang.String)baseTypeData().getElementValueAsString(92);
    }

    public void setHotel_City_Code(java.lang.String Hotel_City_Code) {
        baseTypeData().setElementValue(14, Hotel_City_Code);
    }

    public void setCurrency(java.lang.String Currency) {
        baseTypeData().setElementValue(21, Currency);
    }

    public java.math.BigDecimal getTotal() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(20);
    }

    public java.lang.String getChild1_Type() {
        return (java.lang.String)baseTypeData().getElementValueAsString(42);
    }

    public java.lang.String getRateplndesc() {
        return (java.lang.String)baseTypeData().getElementValueAsString(77);
    }

    public java.lang.String getHotel_Name() {
        return (java.lang.String)baseTypeData().getElementValueAsString(23);
    }

    public void setTaxes(java.math.BigDecimal Taxes) {
        baseTypeData().setElementValue(17, Taxes);
    }

    public java.lang.String getChild1_Age() {
        return (java.lang.String)baseTypeData().getElementValueAsString(36);
    }

    public java.math.BigDecimal getCancel_Min_Fee() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(85);
    }

    public void setTotal_Hotel_Cost(java.math.BigDecimal Total_Hotel_Cost) {
        baseTypeData().setElementValue(80, Total_Hotel_Cost);
    }

    public java.lang.String getDuration() {
        return (java.lang.String)baseTypeData().getElementValueAsString(26);
    }

    public java.lang.String getChild5_Type() {
        return (java.lang.String)baseTypeData().getElementValueAsString(46);
    }

    public java.lang.String getGuarantee_Type() {
        return (java.lang.String)baseTypeData().getElementValueAsString(6);
    }

    public java.lang.String getCity() {
        return (java.lang.String)baseTypeData().getElementValueAsString(71);
    }

    public java.math.BigDecimal getCommission() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(29);
    }

    public void setGds_Hotel_Code(java.lang.String Gds_Hotel_Code) {
        baseTypeData().setElementValue(64, Gds_Hotel_Code);
    }

    public void setMealplan_Desc(java.lang.String Mealplan_Desc) {
        baseTypeData().setElementValue(79, Mealplan_Desc);
    }

    public void setItem_Rph(java.lang.String Item_Rph) {
        baseTypeData().setElementValue(0, Item_Rph);
    }

    public void setLine1(java.lang.String Line1) {
        baseTypeData().setElementValue(69, Line1);
    }

    public java.math.BigDecimal getAdult_Base_Price() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(54);
    }

    public void setEmail(java.lang.String Email) {
        baseTypeData().setElementValue(76, Email);
    }

    public void setChild_Base_Price(java.math.BigDecimal Child_Base_Price) {
        baseTypeData().setElementValue(55, Child_Base_Price);
    }

    public java.lang.String getFlight_Req_Type() {
        return (java.lang.String)baseTypeData().getElementValueAsString(62);
    }

    public void setChild3_Age(java.lang.String Child3_Age) {
        baseTypeData().setElementValue(38, Child3_Age);
    }

    public java.lang.String getCancel_Cutoffdays() {
        return (java.lang.String)baseTypeData().getElementValueAsString(82);
    }

    public void setPosnr(java.lang.String Posnr) {
        baseTypeData().setElementValue(60, Posnr);
    }

    public java.math.BigDecimal getTotal_Transfer_Cost() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(81);
    }

    public java.lang.String getChild6_Age() {
        return (java.lang.String)baseTypeData().getElementValueAsString(41);
    }

    public void setHotel_Chain(java.lang.String Hotel_Chain) {
        baseTypeData().setElementValue(15, Hotel_Chain);
    }

    public java.lang.String getCancel_Policycode() {
        return (java.lang.String)baseTypeData().getElementValueAsString(91);
    }

    public java.lang.String getCountrycode() {
        return (java.lang.String)baseTypeData().getElementValueAsString(74);
    }

    public void setCorpinfo_Code(java.lang.String Corpinfo_Code) {
        baseTypeData().setElementValue(5, Corpinfo_Code);
    }

    public void setNo_Infants(java.lang.String No_Infants) {
        baseTypeData().setElementValue(52, No_Infants);
    }

    public java.lang.String getCurrency() {
        return (java.lang.String)baseTypeData().getElementValueAsString(21);
    }

    public void setPrice_Change_Ind(java.lang.String Price_Change_Ind) {
        baseTypeData().setElementValue(28, Price_Change_Ind);
    }

    public void setCommission(java.math.BigDecimal Commission) {
        baseTypeData().setElementValue(29, Commission);
    }

    public void setPax_Alloc_Rph(java.lang.String Pax_Alloc_Rph) {
        baseTypeData().setElementValue(22, Pax_Alloc_Rph);
    }

    public void setRoomtypecode(java.lang.String Roomtypecode) {
        baseTypeData().setElementValue(1, Roomtypecode);
    }

    public java.math.BigDecimal getCancel_Max_Fee() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(88);
    }

    public void setPromo_Savings(java.math.BigDecimal Promo_Savings) {
        baseTypeData().setElementValue(18, Promo_Savings);
    }

    public java.math.BigDecimal getJunior_Base_Price() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(57);
    }

    public void setChild4_Type(java.lang.String Child4_Type) {
        baseTypeData().setElementValue(45, Child4_Type);
    }

    public void setMealplan_Code(java.lang.String Mealplan_Code) {
        baseTypeData().setElementValue(78, Mealplan_Code);
    }

    public java.lang.String getOrigin_Location() {
        return (java.lang.String)baseTypeData().getElementValueAsString(13);
    }

    public void setLine2(java.lang.String Line2) {
        baseTypeData().setElementValue(70, Line2);
    }

    public java.lang.String getGds_Hotel_Code() {
        return (java.lang.String)baseTypeData().getElementValueAsString(64);
    }

    public void setTotal(java.math.BigDecimal Total) {
        baseTypeData().setElementValue(20, Total);
    }

    public void setPostalcode(java.lang.String Postalcode) {
        baseTypeData().setElementValue(73, Postalcode);
    }

    public java.math.BigDecimal getSenior_Base_Price() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(56);
    }

    public java.lang.String getItem_Rph() {
        return (java.lang.String)baseTypeData().getElementValueAsString(0);
    }

    public void setResort_Area(java.lang.String Resort_Area) {
        baseTypeData().setElementValue(25, Resort_Area);
    }

    public void setRateplancode(java.lang.String Rateplancode) {
        baseTypeData().setElementValue(3, Rateplancode);
    }

    public java.math.BigDecimal getCommission_Prct() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(30);
    }

    public java.lang.String getSource_Roomtypecode() {
        return (java.lang.String)baseTypeData().getElementValueAsString(68);
    }

    public java.lang.String getChild3_Age() {
        return (java.lang.String)baseTypeData().getElementValueAsString(38);
    }

    public java.lang.String getChild2_Type() {
        return (java.lang.String)baseTypeData().getElementValueAsString(43);
    }

    public void setCancel_Min_Dura(java.lang.String Cancel_Min_Dura) {
        baseTypeData().setElementValue(83, Cancel_Min_Dura);
    }

    public java.lang.String getChild6_Type() {
        return (java.lang.String)baseTypeData().getElementValueAsString(47);
    }

    public java.lang.String getNo_Infants() {
        return (java.lang.String)baseTypeData().getElementValueAsString(52);
    }

    public java.math.BigDecimal getTaxes() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(17);
    }

    public void setCancel_Min_Days(java.lang.String Cancel_Min_Days) {
        baseTypeData().setElementValue(84, Cancel_Min_Days);
    }

    public java.lang.String getNo_Adults() {
        return (java.lang.String)baseTypeData().getElementValueAsString(35);
    }

    public void setPkg_Htl_Nochange(java.lang.String Pkg_Htl_Nochange) {
        baseTypeData().setElementValue(63, Pkg_Htl_Nochange);
    }

    public java.lang.String getCancel_Mid_Days() {
        return (java.lang.String)baseTypeData().getElementValueAsString(89);
    }

    public java.lang.String getPrice_Change_Ind() {
        return (java.lang.String)baseTypeData().getElementValueAsString(28);
    }

    public void setDep_Date(java.sql.Date Dep_Date) {
        baseTypeData().setElementValue(12, Dep_Date);
    }

    public void setTotal_Transfer_Cost(java.math.BigDecimal Total_Transfer_Cost) {
        baseTypeData().setElementValue(81, Total_Transfer_Cost);
    }

    public void setOld_Posnr(java.lang.String Old_Posnr) {
        baseTypeData().setElementValue(61, Old_Posnr);
    }

    public java.math.BigDecimal getPer_Adult_Base_Price() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(59);
    }

    public void setNo_Lapchild(java.lang.String No_Lapchild) {
        baseTypeData().setElementValue(53, No_Lapchild);
    }

    public java.lang.String getFree_Nights() {
        return (java.lang.String)baseTypeData().getElementValueAsString(16);
    }

    public java.lang.String getRoomtypecode() {
        return (java.lang.String)baseTypeData().getElementValueAsString(1);
    }

    public void setChild5_Age(java.lang.String Child5_Age) {
        baseTypeData().setElementValue(40, Child5_Age);
    }

    public void setGuarantee_Method(java.lang.String Guarantee_Method) {
        baseTypeData().setElementValue(7, Guarantee_Method);
    }

    public java.lang.String getGuarantee_Req() {
        return (java.lang.String)baseTypeData().getElementValueAsString(8);
    }

    public void setPhonenumber(java.lang.String Phonenumber) {
        baseTypeData().setElementValue(75, Phonenumber);
    }

    public java.lang.String getPostalcode() {
        return (java.lang.String)baseTypeData().getElementValueAsString(73);
    }

    public void setSource_Pnrno(java.lang.String Source_Pnrno) {
        baseTypeData().setElementValue(66, Source_Pnrno);
    }

    public void setSavings(java.math.BigDecimal Savings) {
        baseTypeData().setElementValue(19, Savings);
    }

    public java.lang.String getRateplancode() {
        return (java.lang.String)baseTypeData().getElementValueAsString(3);
    }

    public void setFlt_Item_Rph(java.lang.String Flt_Item_Rph) {
        baseTypeData().setElementValue(31, Flt_Item_Rph);
    }

    public java.lang.String getCancel_Max_Dura() {
        return (java.lang.String)baseTypeData().getElementValueAsString(86);
    }

    public void setRate_Plan_Catg(java.lang.String Rate_Plan_Catg) {
        baseTypeData().setElementValue(9, Rate_Plan_Catg);
    }

    public void setNo_Seniors(java.lang.String No_Seniors) {
        baseTypeData().setElementValue(51, No_Seniors);
    }

    public void setCancel_Policydesc(java.lang.String Cancel_Policydesc) {
        baseTypeData().setElementValue(92, Cancel_Policydesc);
    }

    public void setCancel_Mid_Fee(java.math.BigDecimal Cancel_Mid_Fee) {
        baseTypeData().setElementValue(90, Cancel_Mid_Fee);
    }

    public java.lang.String getCancel_Max_Days() {
        return (java.lang.String)baseTypeData().getElementValueAsString(87);
    }

    public void setSource_Partner(java.lang.String Source_Partner) {
        baseTypeData().setElementValue(65, Source_Partner);
    }

    public java.lang.String getHotel_Confirmno() {
        return (java.lang.String)baseTypeData().getElementValueAsString(67);
    }

    public void setSenior_Base_Price(java.math.BigDecimal Senior_Base_Price) {
        baseTypeData().setElementValue(56, Senior_Base_Price);
    }

    public void setChild1_Type(java.lang.String Child1_Type) {
        baseTypeData().setElementValue(42, Child1_Type);
    }

    public void setRateplndesc(java.lang.String Rateplndesc) {
        baseTypeData().setElementValue(77, Rateplndesc);
    }

    public void setRating(java.lang.String Rating) {
        baseTypeData().setElementValue(24, Rating);
    }

    public java.lang.String getPkg_Htl_Nochange() {
        return (java.lang.String)baseTypeData().getElementValueAsString(63);
    }

    public java.lang.String getRateindicator() {
        return (java.lang.String)baseTypeData().getElementValueAsString(4);
    }

    public void setChild5_Type(java.lang.String Child5_Type) {
        baseTypeData().setElementValue(46, Child5_Type);
    }

    public java.math.BigDecimal getChild_Base_Price() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(55);
    }

    public java.math.BigDecimal getPromo_Savings() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(18);
    }

    public void setChild2_Age(java.lang.String Child2_Age) {
        baseTypeData().setElementValue(37, Child2_Age);
    }

    public MetaData metadata() {
        return metadata;
    }

    public java.lang.String getChild5_Age() {
        return (java.lang.String)baseTypeData().getElementValueAsString(40);
    }

    public java.lang.String getGuarantee_Method() {
        return (java.lang.String)baseTypeData().getElementValueAsString(7);
    }

    public java.lang.String getChild3_Type() {
        return (java.lang.String)baseTypeData().getElementValueAsString(44);
    }

    public java.lang.String getStatecode() {
        return (java.lang.String)baseTypeData().getElementValueAsString(72);
    }

    public java.lang.String getSource_Pnrno() {
        return (java.lang.String)baseTypeData().getElementValueAsString(66);
    }

    public java.lang.String getNo_Minors() {
        return (java.lang.String)baseTypeData().getElementValueAsString(50);
    }

    public java.lang.String getFlt_Item_Rph() {
        return (java.lang.String)baseTypeData().getElementValueAsString(31);
    }

    public void setFlight_Req_Type(java.lang.String Flight_Req_Type) {
        baseTypeData().setElementValue(62, Flight_Req_Type);
    }

    public void setCancel_Cutoffdays(java.lang.String Cancel_Cutoffdays) {
        baseTypeData().setElementValue(82, Cancel_Cutoffdays);
    }

    public java.lang.String getHotel_City_Code() {
        return (java.lang.String)baseTypeData().getElementValueAsString(14);
    }

    public java.lang.String getRate_Plan_Catg() {
        return (java.lang.String)baseTypeData().getElementValueAsString(9);
    }

    public void setCancel_Policycode(java.lang.String Cancel_Policycode) {
        baseTypeData().setElementValue(91, Cancel_Policycode);
    }

    public void setCountrycode(java.lang.String Countrycode) {
        baseTypeData().setElementValue(74, Countrycode);
    }

    public java.math.BigDecimal getMinor_Base_Price() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(58);
    }

    public java.lang.String getNo_Seniors() {
        return (java.lang.String)baseTypeData().getElementValueAsString(51);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Yst_Ota_Htl_ItemsType parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Yst_Ota_Htl_ItemsType parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getSource_Partner() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(65);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getAdult_Base_Price() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(54);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getFlight_Req_Type() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(62);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCancel_Cutoffdays() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(82);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getRating() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(24);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getTotal_Transfer_Cost() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(81);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getChild6_Age() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(41);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCancel_Policycode() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(91);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getMealplan_Desc() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(79);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCountrycode() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(74);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getChild2_Age() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(37);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getLine1() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(69);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCurrency() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(21);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getEmail() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(76);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getSavings() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(19);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getPosnr() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(60);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getArr_Date() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(11);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getHotel_Chain() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(15);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCorpinfo_Code() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCancel_Max_Fee() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(88);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getJunior_Base_Price() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(57);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getOrigin_Location() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(13);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getGds_Hotel_Code() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(64);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getSenior_Base_Price() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(56);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getItem_Rph() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getPax_Alloc_Rph() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(22);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCommission_Prct() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(30);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getSource_Roomtypecode() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(68);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getChild3_Age() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(38);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getChild2_Type() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(43);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getChild4_Type() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(45);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getMealplan_Code() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(78);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getChild6_Type() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(47);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getLine2() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(70);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getRoom_Type_Desc() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getRate_Plan_Id() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(10);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getNo_Infants() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(52);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getResort_Area() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(25);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getTaxes() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(17);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getNo_Juniors() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(49);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getTransfer_Alloc_Rph() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(33);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getNo_Adults() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(35);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCancel_Mid_Fee() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(90);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCancel_Mid_Days() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(89);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCancel_Min_Dura() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(83);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getPrice_Change_Ind() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(28);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getPer_Adult_Base_Price() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(59);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getFree_Nights() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(16);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getRoomtypecode() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getNo_Child() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(48);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getDep_Date() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(12);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCancel_Min_Days() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(84);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getGuarantee_Req() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(8);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getPostalcode() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(73);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getHotel_Code() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(27);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getChild4_Age() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(39);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getRateplancode() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCancel_Max_Dura() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(86);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getOld_Posnr() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(61);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getTotal_Hotel_Cost() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(80);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getNo_Lapchild() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(53);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCancel_Max_Days() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(87);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getPhonenumber() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(75);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getHotel_Confirmno() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(67);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getPkg_Total() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(34);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getVeh_Item_Rph() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(32);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getPkg_Htl_Nochange() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(63);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getRateindicator() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getChild_Base_Price() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(55);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getPromo_Savings() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(18);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCancel_Policydesc() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(92);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getChild5_Age() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(40);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getTotal() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(20);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getGuarantee_Method() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(7);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getChild1_Type() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(42);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getRateplndesc() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(77);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getHotel_Name() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(23);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getChild3_Type() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(44);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getChild1_Age() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(36);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCancel_Min_Fee() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(85);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getDuration() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(26);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getChild5_Type() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(46);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getStatecode() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(72);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getSource_Pnrno() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(66);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getGuarantee_Type() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(6);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getNo_Minors() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(50);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getFlt_Item_Rph() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(31);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCity() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(71);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCommission() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(29);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getHotel_City_Code() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(14);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getRate_Plan_Catg() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(9);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getMinor_Base_Price() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(58);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getNo_Seniors() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(51);
        }
    
    }

}
