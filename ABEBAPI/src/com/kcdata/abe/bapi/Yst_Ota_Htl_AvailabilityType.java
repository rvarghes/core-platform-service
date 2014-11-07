package com.kcdata.abe.bapi;
public class Yst_Ota_Htl_AvailabilityType extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1387183751954L) ;

    private  Yst_Ota_Htl_AvailabilityType.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.XSDL_COMPLEX_TYPE, "urn:sap-com:document:sap:rfc:functions", "YST_OTA_HTL_AVAILABILITY", 20, 0, com.kcdata.abe.bapi.Yst_Ota_Htl_AvailabilityType.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "YST_OTA_HTL_AVAILABILITY", 411, 816, -1, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_OTA_HTL_AVAILABILITY\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">OTA Hotel Availability</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>411</ifr:internalLength1><ifr:internalLength2>816</ifr:internalLength2></ifr:definition></ifr:container></s0:type>");
        descriptorSetElementProperties(descriptor, 0, "ITEM_RPH", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Item_Rph", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "3"}}, "ITEM_RPH", 0, 0, -1, 3, 6, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ITEM_RPH\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Item RPH</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>0</ifr:offset1><ifr:offset2>0</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YITEM_RPH\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>3</ifr:length><ifr:internalLength1>3</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>3</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 1, "ROOM_CAT_RPH", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Room_Cat_Rph", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "2"}}, "ROOM_CAT_RPH", 3, 6, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ROOM_CAT_RPH\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Room Category RPH</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>3</ifr:offset1><ifr:offset2>6</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YROOM_CAT_RPH\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 2, "ROOMTYPECODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Roomtypecode", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "20"}}, "ROOMTYPECODE", 5, 10, -1, 20, 40, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ROOMTYPECODE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Room Type Code</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>5</ifr:offset1><ifr:offset2>10</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YROOM_TYPE_CODE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>20</ifr:length><ifr:internalLength1>20</ifr:internalLength1><ifr:internalLength2>40</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>20</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 3, "RATEPLANCODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Rateplancode", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "20"}}, "RATEPLANCODE", 25, 50, -1, 20, 40, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"RATEPLANCODE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Rate Plan Code</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>25</ifr:offset1><ifr:offset2>50</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YRATE_PLAN_CODE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>20</ifr:length><ifr:internalLength1>20</ifr:internalLength1><ifr:internalLength2>40</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>20</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 4, "ROOM_TYPE_DESC", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Room_Type_Desc", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "100"}}, "ROOM_TYPE_DESC", 45, 90, -1, 100, 200, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ROOM_TYPE_DESC\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Room Type Description</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>45</ifr:offset1><ifr:offset2>90</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZROOMTYPDESC\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>100</ifr:length><ifr:internalLength1>100</ifr:internalLength1><ifr:internalLength2>200</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>100</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 5, "RATE_PLAN_DESC", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Rate_Plan_Desc", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "100"}}, "RATE_PLAN_DESC", 145, 290, -1, 100, 200, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"RATE_PLAN_DESC\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Rate Plan Description</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>145</ifr:offset1><ifr:offset2>290</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZRATEPLNDESC\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>100</ifr:length><ifr:internalLength1>100</ifr:internalLength1><ifr:internalLength2>200</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>100</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 6, "RATEINDICATOR", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Rateindicator", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "25"}}, "RATEINDICATOR", 245, 490, -1, 25, 50, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"RATEINDICATOR\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Rate Indicator</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>245</ifr:offset1><ifr:offset2>490</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YRATEINDICATOR\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>25</ifr:length><ifr:internalLength1>25</ifr:internalLength1><ifr:internalLength2>50</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>25</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 7, "CORPINFO_CODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Corpinfo_Code", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "30"}}, "CORPINFO_CODE", 270, 540, -1, 30, 60, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CORPINFO_CODE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Company identification for room reservation</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>270</ifr:offset1><ifr:offset2>540</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"HOTEL_CORPORATE_ID\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>30</ifr:length><ifr:internalLength1>30</ifr:internalLength1><ifr:internalLength2>60</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>30</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 8, "GUARANTEE_TYPE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Guarantee_Type", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "40"}}, "GUARANTEE_TYPE", 300, 600, -1, 40, 80, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"GUARANTEE_TYPE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Guarantee for room reservation at booking</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>300</ifr:offset1><ifr:offset2>600</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"HOTEL_GUARANTEE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>40</ifr:length><ifr:internalLength1>40</ifr:internalLength1><ifr:internalLength2>80</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>40</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 9, "GUARANTEE_METHOD", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Guarantee_Method", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "25"}}, "GUARANTEE_METHOD", 340, 680, -1, 25, 50, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"GUARANTEE_METHOD\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Guarantee Method</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>340</ifr:offset1><ifr:offset2>680</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YGUARANTEE_METHOD\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>true</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>25</ifr:length><ifr:internalLength1>25</ifr:internalLength1><ifr:internalLength2>50</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>25</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 10, "GUARANTEE_REQ", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Guarantee_Req", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "5"}}, "GUARANTEE_REQ", 365, 730, -1, 5, 10, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"GUARANTEE_REQ\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Guarantee Require</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>365</ifr:offset1><ifr:offset2>730</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZGUARANTEE_REQ\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>5</ifr:length><ifr:internalLength1>5</ifr:internalLength1><ifr:internalLength2>10</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>5</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 11, "GUARANTEE_AMOUNT", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:decimal", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Guarantee_Amount", java.math.BigDecimal.class, null, new java.lang.String[][]{{"totalDigits", "10"}, {"fractionDigits", "2"}}, "GUARANTEE_AMOUNT", 370, 740, -1, 6, 6, -1, com.sap.mw.jco.JCO.TYPE_BCD, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"GUARANTEE_AMOUNT\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Guaran. Amount</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:referenceField>CURRENCY</ifr:referenceField><ifr:referenceTable>YST_OTA_HTL_AVAILABILITY</ifr:referenceTable><ifr:offset1>370</ifr:offset1><ifr:offset2>740</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"HOTEL_GUARANTEE_AMOUNT\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CURR</ifr:type><ifr:abapType>P</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>6</ifr:internalLength1><ifr:internalLength2>6</ifr:internalLength2><ifr:decimals>2</ifr:decimals><ifr:outputLength>13</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 12, "RATE_PLAN_CATG", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Rate_Plan_Catg", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "9"}}, "RATE_PLAN_CATG", 376, 746, -1, 9, 18, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"RATE_PLAN_CATG\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Rate Plan Category ( Material Group )</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>376</ifr:offset1><ifr:offset2>746</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YRATE_PLAN_CATG\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>9</ifr:length><ifr:internalLength1>9</ifr:internalLength1><ifr:internalLength2>18</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>9</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 13, "AVAIL_ROOMS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Avail_Rooms", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "5"}}, "AVAIL_ROOMS", 385, 764, -1, 5, 10, -1, com.sap.mw.jco.JCO.TYPE_NUM, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"AVAIL_ROOMS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">No Of Rooms Available</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>385</ifr:offset1><ifr:offset2>764</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YAVAIL_ROOMS\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>5</ifr:length><ifr:internalLength1>5</ifr:internalLength1><ifr:internalLength2>10</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>5</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 14, "STATUS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Status", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "2"}}, "STATUS", 390, 774, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"STATUS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Hotel Status</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>390</ifr:offset1><ifr:offset2>774</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"HOTEL_STATUS\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>true</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 15, "CURRENCY", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Currency", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "5"}}, "CURRENCY", 392, 778, -1, 5, 10, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CURRENCY\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Currency</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>392</ifr:offset1><ifr:offset2>778</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"HOTEL_CURRENCY\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CUKY</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>5</ifr:length><ifr:internalLength1>5</ifr:internalLength1><ifr:internalLength2>10</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>5</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 16, "RATE_PLAN_ID", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Rate_Plan_Id", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "RATE_PLAN_ID", 397, 788, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"RATE_PLAN_ID\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Rate Plan ID C-Charter/S-Sked/L-Land Only</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>397</ifr:offset1><ifr:offset2>788</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YRATE_PLAN_ID\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>true</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 17, "MEAL_INFO", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Meal_Info", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "10"}}, "MEAL_INFO", 398, 790, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"MEAL_INFO\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Meal Info</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>398</ifr:offset1><ifr:offset2>790</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YMEAL_INFO\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 18, "RISK", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Risk", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "RISK", 408, 810, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"RISK\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Risk</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>408</ifr:offset1><ifr:offset2>810</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZRISK\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 19, "APPLE_CHOICE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Apple_Choice", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "2"}}, "APPLE_CHOICE", 409, 812, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"APPLE_CHOICE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Apple Choice.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>409</ifr:offset1><ifr:offset2>812</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZZAPPLE_CHOICE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        staticDescriptor = descriptor;
    }
    protected  Yst_Ota_Htl_AvailabilityType (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Yst_Ota_Htl_AvailabilityType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public java.lang.String getRoomtypecode() {
        return (java.lang.String)baseTypeData().getElementValueAsString(2);
    }

    public void setGuarantee_Method(java.lang.String Guarantee_Method) {
        baseTypeData().setElementValue(9, Guarantee_Method);
    }

    public java.lang.String getRoom_Cat_Rph() {
        return (java.lang.String)baseTypeData().getElementValueAsString(1);
    }

    public java.lang.String getGuarantee_Req() {
        return (java.lang.String)baseTypeData().getElementValueAsString(10);
    }

    public void setRate_Plan_Id(java.lang.String Rate_Plan_Id) {
        baseTypeData().setElementValue(16, Rate_Plan_Id);
    }

    public void setRoom_Type_Desc(java.lang.String Room_Type_Desc) {
        baseTypeData().setElementValue(4, Room_Type_Desc);
    }

    public void setGuarantee_Type(java.lang.String Guarantee_Type) {
        baseTypeData().setElementValue(8, Guarantee_Type);
    }

    public void setCorpinfo_Code(java.lang.String Corpinfo_Code) {
        baseTypeData().setElementValue(7, Corpinfo_Code);
    }

    public java.lang.String getRateplancode() {
        return (java.lang.String)baseTypeData().getElementValueAsString(3);
    }

    public java.lang.String getStatus() {
        return (java.lang.String)baseTypeData().getElementValueAsString(14);
    }

    public void setRateindicator(java.lang.String Rateindicator) {
        baseTypeData().setElementValue(6, Rateindicator);
    }

    public java.lang.String getCurrency() {
        return (java.lang.String)baseTypeData().getElementValueAsString(15);
    }

    public java.lang.String getRisk() {
        return (java.lang.String)baseTypeData().getElementValueAsString(18);
    }

    public void setRate_Plan_Catg(java.lang.String Rate_Plan_Catg) {
        baseTypeData().setElementValue(12, Rate_Plan_Catg);
    }

    public void setRate_Plan_Desc(java.lang.String Rate_Plan_Desc) {
        baseTypeData().setElementValue(5, Rate_Plan_Desc);
    }

    public java.math.BigDecimal getGuarantee_Amount() {
        return (java.math.BigDecimal)baseTypeData().getElementValueAsBigDecimal(11);
    }

    public void setApple_Choice(java.lang.String Apple_Choice) {
        baseTypeData().setElementValue(19, Apple_Choice);
    }

    public void setMeal_Info(java.lang.String Meal_Info) {
        baseTypeData().setElementValue(17, Meal_Info);
    }

    public void setAvail_Rooms(java.lang.String Avail_Rooms) {
        baseTypeData().setElementValue(13, Avail_Rooms);
    }

    public void setRoomtypecode(java.lang.String Roomtypecode) {
        baseTypeData().setElementValue(2, Roomtypecode);
    }

    public java.lang.String getCorpinfo_Code() {
        return (java.lang.String)baseTypeData().getElementValueAsString(7);
    }

    public void setRoom_Cat_Rph(java.lang.String Room_Cat_Rph) {
        baseTypeData().setElementValue(1, Room_Cat_Rph);
    }

    public java.lang.String getRateindicator() {
        return (java.lang.String)baseTypeData().getElementValueAsString(6);
    }

    public java.lang.String getMeal_Info() {
        return (java.lang.String)baseTypeData().getElementValueAsString(17);
    }

    public java.lang.String getItem_Rph() {
        return (java.lang.String)baseTypeData().getElementValueAsString(0);
    }

    public void setRateplancode(java.lang.String Rateplancode) {
        baseTypeData().setElementValue(3, Rateplancode);
    }

    public java.lang.String getAvail_Rooms() {
        return (java.lang.String)baseTypeData().getElementValueAsString(13);
    }

    public MetaData metadata() {
        return metadata;
    }

    public void setStatus(java.lang.String Status) {
        baseTypeData().setElementValue(14, Status);
    }

    public void setCurrency(java.lang.String Currency) {
        baseTypeData().setElementValue(15, Currency);
    }

    public java.lang.String getGuarantee_Method() {
        return (java.lang.String)baseTypeData().getElementValueAsString(9);
    }

    public void setRisk(java.lang.String Risk) {
        baseTypeData().setElementValue(18, Risk);
    }

    public java.lang.String getRate_Plan_Id() {
        return (java.lang.String)baseTypeData().getElementValueAsString(16);
    }

    public java.lang.String getRoom_Type_Desc() {
        return (java.lang.String)baseTypeData().getElementValueAsString(4);
    }

    public java.lang.String getGuarantee_Type() {
        return (java.lang.String)baseTypeData().getElementValueAsString(8);
    }

    public void setGuarantee_Amount(java.math.BigDecimal Guarantee_Amount) {
        baseTypeData().setElementValue(11, Guarantee_Amount);
    }

    public void setGuarantee_Req(java.lang.String Guarantee_Req) {
        baseTypeData().setElementValue(10, Guarantee_Req);
    }

    public java.lang.String getRate_Plan_Desc() {
        return (java.lang.String)baseTypeData().getElementValueAsString(5);
    }

    public java.lang.String getRate_Plan_Catg() {
        return (java.lang.String)baseTypeData().getElementValueAsString(12);
    }

    public java.lang.String getApple_Choice() {
        return (java.lang.String)baseTypeData().getElementValueAsString(19);
    }

    public void setItem_Rph(java.lang.String Item_Rph) {
        baseTypeData().setElementValue(0, Item_Rph);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Yst_Ota_Htl_AvailabilityType parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Yst_Ota_Htl_AvailabilityType parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getRateindicator() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(6);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getRoomtypecode() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getMeal_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(17);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getItem_Rph() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getRoom_Cat_Rph() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getAvail_Rooms() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(13);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getGuarantee_Req() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(10);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getGuarantee_Method() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(9);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getRateplancode() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getRate_Plan_Id() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(16);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getStatus() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(14);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getRoom_Type_Desc() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCurrency() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(15);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getGuarantee_Type() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(8);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getRisk() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(18);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getGuarantee_Amount() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(11);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getRate_Plan_Catg() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(12);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getRate_Plan_Desc() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCorpinfo_Code() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(7);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getApple_Choice() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(19);
        }
    
    }

}
