package com.kcdata.abe.bapi;
public class Yst_Bapi_Veh_InfoType extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1296044373562L) ;

    private  Yst_Bapi_Veh_InfoType.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.XSDL_COMPLEX_TYPE, "urn:sap-com:document:sap:rfc:functions", "YST_BAPI_VEH_INFO", 14, 0, com.kcdata.abe.bapi.Yst_Bapi_Veh_InfoType.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "YST_BAPI_VEH_INFO", 2732, 5464, -1, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_VEH_INFO\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Rental Car Information</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>2732</ifr:internalLength1><ifr:internalLength2>5464</ifr:internalLength2></ifr:definition></ifr:container></s0:type>");
        descriptorSetElementProperties(descriptor, 0, "VENDORCODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Vendorcode", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "2"}}, "VENDORCODE", 0, 0, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"VENDORCODE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Vendor Codes</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>0</ifr:offset1><ifr:offset2>0</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"YVENDORCODE\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>true</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 1, "CASHDEPOSITREQUIRED", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Cashdepositrequired", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "100"}}, "CASHDEPOSITREQUIRED", 2, 4, -1, 100, 200, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CASHDEPOSITREQUIRED\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Cash Required.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>2</ifr:offset1><ifr:offset2>4</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZCASHRQD\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>100</ifr:length><ifr:internalLength1>100</ifr:internalLength1><ifr:internalLength2>200</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>100</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 2, "AGEREQUIRED", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Agerequired", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "255"}}, "AGEREQUIRED", 102, 204, -1, 255, 510, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"AGEREQUIRED\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Age Requirements.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>102</ifr:offset1><ifr:offset2>204</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZAGERQMT\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>255</ifr:length><ifr:internalLength1>255</ifr:internalLength1><ifr:internalLength2>510</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>255</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 3, "ADDITIONALDRIVERS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Additionaldrivers", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "255"}}, "ADDITIONALDRIVERS", 357, 714, -1, 255, 510, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"ADDITIONALDRIVERS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Additional Drivers.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>357</ifr:offset1><ifr:offset2>714</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZADDRV\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>255</ifr:length><ifr:internalLength1>255</ifr:internalLength1><ifr:internalLength2>510</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>255</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 4, "OPTIONS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Options", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "255"}}, "OPTIONS", 612, 1224, -1, 255, 510, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"OPTIONS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Options</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>612</ifr:offset1><ifr:offset2>1224</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZOPTIONS\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>255</ifr:length><ifr:internalLength1>255</ifr:internalLength1><ifr:internalLength2>510</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>255</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 5, "PICKUPDROPOFFLOCATIONS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Pickupdropofflocations", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "255"}}, "PICKUPDROPOFFLOCATIONS", 867, 1734, -1, 255, 510, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"PICKUPDROPOFFLOCATIONS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Pickup and Dropoff Locations</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>867</ifr:offset1><ifr:offset2>1734</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZPICKDRP\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>255</ifr:length><ifr:internalLength1>255</ifr:internalLength1><ifr:internalLength2>510</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>255</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 6, "FUELMILEAGE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Fuelmileage", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "50"}}, "FUELMILEAGE", 1122, 2244, -1, 50, 100, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"FUELMILEAGE\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Fuel and Mileages.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1122</ifr:offset1><ifr:offset2>2244</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZFUELMG\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>50</ifr:length><ifr:internalLength1>50</ifr:internalLength1><ifr:internalLength2>100</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>50</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 7, "TAXES", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Taxes", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "255"}}, "TAXES", 1172, 2344, -1, 255, 510, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"TAXES\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Taxes.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1172</ifr:offset1><ifr:offset2>2344</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZTAXES\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>255</ifr:length><ifr:internalLength1>255</ifr:internalLength1><ifr:internalLength2>510</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>255</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 8, "GENERALREQUIREMENTS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Generalrequirements", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "255"}}, "GENERALREQUIREMENTS", 1427, 2854, -1, 255, 510, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"GENERALREQUIREMENTS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">General Requirements</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1427</ifr:offset1><ifr:offset2>2854</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZGENRQMT\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>255</ifr:length><ifr:internalLength1>255</ifr:internalLength1><ifr:internalLength2>510</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>255</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 9, "SEATBELTSCHILDRESTRAINTS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Seatbeltschildrestraints", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "255"}}, "SEATBELTSCHILDRESTRAINTS", 1682, 3364, -1, 255, 510, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"SEATBELTSCHILDRESTRAINTS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Seat belt and Child Restraints</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1682</ifr:offset1><ifr:offset2>3364</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZSEATBLT\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>255</ifr:length><ifr:internalLength1>255</ifr:internalLength1><ifr:internalLength2>510</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>255</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 10, "DRIVINGAREAS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Drivingareas", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "255"}}, "DRIVINGAREAS", 1937, 3874, -1, 255, 510, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"DRIVINGAREAS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Driving Areas</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>1937</ifr:offset1><ifr:offset2>3874</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZDRIVAR\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>255</ifr:length><ifr:internalLength1>255</ifr:internalLength1><ifr:internalLength2>510</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>255</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 11, "AVAILABLEDESTINATIONS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Availabledestinations", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "255"}}, "AVAILABLEDESTINATIONS", 2192, 4384, -1, 255, 510, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"AVAILABLEDESTINATIONS\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Available destinations</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>2192</ifr:offset1><ifr:offset2>4384</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZAVDEST\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>255</ifr:length><ifr:internalLength1>255</ifr:internalLength1><ifr:internalLength2>510</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>255</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 12, "MARKETSTRATEGY", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Marketstrategy", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "255"}}, "MARKETSTRATEGY", 2447, 4894, -1, 255, 510, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"MARKETSTRATEGY\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Car Types</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>2447</ifr:offset1><ifr:offset2>4894</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZCARTYPE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>255</ifr:length><ifr:internalLength1>255</ifr:internalLength1><ifr:internalLength2>510</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>255</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 13, "CARCOMPANYNAME", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Carcompanyname", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "30"}}, "CARCOMPANYNAME", 2702, 5404, -1, 30, 60, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CARCOMPANYNAME\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Car Company Name.</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>2702</ifr:offset1><ifr:offset2>5404</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZCARCMP\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>30</ifr:length><ifr:internalLength1>30</ifr:internalLength1><ifr:internalLength2>60</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>30</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        staticDescriptor = descriptor;
    }
    public  Yst_Bapi_Veh_InfoType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Yst_Bapi_Veh_InfoType (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public java.lang.String getFuelmileage() {
        return (java.lang.String)baseTypeData().getElementValueAsString(6);
    }

    public java.lang.String getVendorcode() {
        return (java.lang.String)baseTypeData().getElementValueAsString(0);
    }

    public java.lang.String getGeneralrequirements() {
        return (java.lang.String)baseTypeData().getElementValueAsString(8);
    }

    public java.lang.String getAdditionaldrivers() {
        return (java.lang.String)baseTypeData().getElementValueAsString(3);
    }

    public java.lang.String getCarcompanyname() {
        return (java.lang.String)baseTypeData().getElementValueAsString(13);
    }

    public java.lang.String getAgerequired() {
        return (java.lang.String)baseTypeData().getElementValueAsString(2);
    }

    public void setAvailabledestinations(java.lang.String Availabledestinations) {
        baseTypeData().setElementValue(11, Availabledestinations);
    }

    public MetaData metadata() {
        return metadata;
    }

    public java.lang.String getAvailabledestinations() {
        return (java.lang.String)baseTypeData().getElementValueAsString(11);
    }

    public void setCarcompanyname(java.lang.String Carcompanyname) {
        baseTypeData().setElementValue(13, Carcompanyname);
    }

    public void setSeatbeltschildrestraints(java.lang.String Seatbeltschildrestraints) {
        baseTypeData().setElementValue(9, Seatbeltschildrestraints);
    }

    public void setFuelmileage(java.lang.String Fuelmileage) {
        baseTypeData().setElementValue(6, Fuelmileage);
    }

    public java.lang.String getDrivingareas() {
        return (java.lang.String)baseTypeData().getElementValueAsString(10);
    }

    public java.lang.String getTaxes() {
        return (java.lang.String)baseTypeData().getElementValueAsString(7);
    }

    public void setGeneralrequirements(java.lang.String Generalrequirements) {
        baseTypeData().setElementValue(8, Generalrequirements);
    }

    public java.lang.String getOptions() {
        return (java.lang.String)baseTypeData().getElementValueAsString(4);
    }

    public void setCashdepositrequired(java.lang.String Cashdepositrequired) {
        baseTypeData().setElementValue(1, Cashdepositrequired);
    }

    public void setDrivingareas(java.lang.String Drivingareas) {
        baseTypeData().setElementValue(10, Drivingareas);
    }

    public void setOptions(java.lang.String Options) {
        baseTypeData().setElementValue(4, Options);
    }

    public void setVendorcode(java.lang.String Vendorcode) {
        baseTypeData().setElementValue(0, Vendorcode);
    }

    public java.lang.String getMarketstrategy() {
        return (java.lang.String)baseTypeData().getElementValueAsString(12);
    }

    public void setAgerequired(java.lang.String Agerequired) {
        baseTypeData().setElementValue(2, Agerequired);
    }

    public java.lang.String getSeatbeltschildrestraints() {
        return (java.lang.String)baseTypeData().getElementValueAsString(9);
    }

    public void setAdditionaldrivers(java.lang.String Additionaldrivers) {
        baseTypeData().setElementValue(3, Additionaldrivers);
    }

    public java.lang.String getCashdepositrequired() {
        return (java.lang.String)baseTypeData().getElementValueAsString(1);
    }

    public java.lang.String getPickupdropofflocations() {
        return (java.lang.String)baseTypeData().getElementValueAsString(5);
    }

    public void setTaxes(java.lang.String Taxes) {
        baseTypeData().setElementValue(7, Taxes);
    }

    public void setMarketstrategy(java.lang.String Marketstrategy) {
        baseTypeData().setElementValue(12, Marketstrategy);
    }

    public void setPickupdropofflocations(java.lang.String Pickupdropofflocations) {
        baseTypeData().setElementValue(5, Pickupdropofflocations);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Yst_Bapi_Veh_InfoType parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Yst_Bapi_Veh_InfoType parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getDrivingareas() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(10);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getTaxes() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(7);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getFuelmileage() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(6);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getVendorcode() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getOptions() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getGeneralrequirements() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(8);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getAdditionaldrivers() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCarcompanyname() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(13);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getAgerequired() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getMarketstrategy() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(12);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getSeatbeltschildrestraints() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(9);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCashdepositrequired() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getPickupdropofflocations() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getAvailabledestinations() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(11);
        }
    
    }

}
