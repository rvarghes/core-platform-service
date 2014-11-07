package com.kcdata.abe.bapi;
public class Y_Ota_Hotel_Availability_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1387183727511L) ;

    private  Y_Ota_Hotel_Availability_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_OTA_HOTEL_AVAILABILITY.Input", 15, 0, com.kcdata.abe.bapi.Y_Ota_Hotel_Availability_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_OTA_HOTEL_AVAILABILITY", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Hotel Availability</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "CH_ST_BAPI_METADATA", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_METADATA", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ch_St_Bapi_Metadata", com.kcdata.abe.bapi.Yst_MetadataType.class, new com.kcdata.abe.bapi.Yst_MetadataType(), new java.lang.String[][]{}, "CH_ST_BAPI_METADATA", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER | com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"CH_ST_BAPI_METADATA\"><ifr:descriptor><ifr:description language=\"EN\">Matadata for BAPI Request Interface</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_METADATA\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_METADATA\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>changing</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IM_APPLICATION_INFO", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_APPLI_INFO", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Application_Info", com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType.class, new com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType(), new java.lang.String[][]{}, "IM_APPLICATION_INFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_APPLICATION_INFO\"><ifr:descriptor><ifr:description language=\"EN\">BAPI Application Info</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_APPLI_INFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_APPLI_INFO\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IM_INCL_DUMMY_HOTELS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Im_Incl_Dummy_Hotels", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "1"}}, "IM_INCL_DUMMY_HOTELS", 0, 0, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_NUM, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_INCL_DUMMY_HOTELS\"><ifr:descriptor><ifr:description language=\"EN\">Include Dummy Hotel Materials</ifr:description></ifr:descriptor><ifr:definition><ifr:scalarType name=\"TRUE_FALSE\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>true</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>NUMC</ifr:type><ifr:abapType>N</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType><ifr:defaultDefinition>&apos;1&apos;</ifr:defaultDefinition></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "IM_REQ_HDR", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_REQ_HDR", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Req_Hdr", com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType.class, new com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType(), new java.lang.String[][]{}, "IM_REQ_HDR", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_REQ_HDR\"><ifr:descriptor><ifr:description language=\"EN\">Hotel Request Header</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_REQ_HDR\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_REQ_HDR\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "IT_RETURN", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Return", com.kcdata.abe.bapi.util.Bapiret2Type_List.class, new com.kcdata.abe.bapi.Bapiret2Type(), new java.lang.String[][]{}, "IT_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRET2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRET2\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 5, "IT_REQUEST_OPT", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Request_Opt", com.kcdata.abe.bapi.util.Yst_Ota_Request_OptType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Request_OptType(), new java.lang.String[][]{}, "IT_REQUEST_OPT", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_REQUEST_OPT\"><ifr:descriptor><ifr:description language=\"EN\">OTA Page Request Options</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_REQUEST_OPT\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_REQUEST_OPT\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 6, "IT_HTL_VEND_SERVICES", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Htl_Vend_Services", com.kcdata.abe.bapi.util.Yst_Ota_Htl_Vend_ServicesType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Htl_Vend_ServicesType(), new java.lang.String[][]{}, "IT_HTL_VEND_SERVICES", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_HTL_VEND_SERVICES\"><ifr:descriptor><ifr:description language=\"EN\">OTA Services offered by Vendor</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_HTL_VEND_SERVICES\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_HTL_VEND_SERVICES\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 7, "IT_HTL_ROOMSTAYCANDIDATES", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Htl_Roomstaycandidates", com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List.class, new com.kcdata.abe.bapi.Yst_Ota_RoomstaycandidatesType(), new java.lang.String[][]{}, "IT_HTL_ROOMSTAYCANDIDATES", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_HTL_ROOMSTAYCANDIDATES\"><ifr:descriptor><ifr:description language=\"EN\">OTA Roomstay Candidates</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_ROOMSTAYCANDIDATES\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_ROOMSTAYCANDIDATES\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 8, "IT_HTL_REQ_AMENITY", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Htl_Req_Amenity", com.kcdata.abe.bapi.util.Yst_Ota_Htl_Req_AmenityType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Htl_Req_AmenityType(), new java.lang.String[][]{}, "IT_HTL_REQ_AMENITY", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_HTL_REQ_AMENITY\"><ifr:descriptor><ifr:description language=\"EN\">OTA Hotel Amenity based search</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_HTL_REQ_AMENITY\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_HTL_REQ_AMENITY\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 9, "IT_HTL_REQ", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Htl_Req", com.kcdata.abe.bapi.util.Yst_Ota_Htl_ReqType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Htl_ReqType(), new java.lang.String[][]{}, "IT_HTL_REQ", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_HTL_REQ\"><ifr:descriptor><ifr:description language=\"EN\">OTA Hotel Request</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_HTL_REQ\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_HTL_REQ\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 10, "IT_HTL_PRICING", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Htl_Pricing", com.kcdata.abe.bapi.util.Yst_Ota_Htl_Room_PricingType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType(), new java.lang.String[][]{}, "IT_HTL_PRICING", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_HTL_PRICING\"><ifr:descriptor><ifr:description language=\"EN\">OTA Hotel Pricing</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_HTL_ROOM_PRICING\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_HTL_ROOM_PRICING\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 11, "IT_HTL_INFO", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Htl_Info", com.kcdata.abe.bapi.util.Yst_Ota_Htl_InfoType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType(), new java.lang.String[][]{}, "IT_HTL_INFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_HTL_INFO\"><ifr:descriptor><ifr:description language=\"EN\">OTA Hotel Info</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_HTL_INFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_HTL_INFO\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 12, "IT_HTL_DEST_SERVICES", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Htl_Dest_Services", com.kcdata.abe.bapi.util.Yst_Ota_Htl_Dest_ServicesType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType(), new java.lang.String[][]{}, "IT_HTL_DEST_SERVICES", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_HTL_DEST_SERVICES\"><ifr:descriptor><ifr:description language=\"EN\">OTA Services offered at Destination</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_HTL_DEST_SERVICES\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_HTL_DEST_SERVICES\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 13, "IT_HTL_AVAILABILITY", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Htl_Availability", com.kcdata.abe.bapi.util.Yst_Ota_Htl_AvailabilityType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Htl_AvailabilityType(), new java.lang.String[][]{}, "IT_HTL_AVAILABILITY", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_HTL_AVAILABILITY\"><ifr:descriptor><ifr:description language=\"EN\">OTA Hotel Availability</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_HTL_AVAILABILITY\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_HTL_AVAILABILITY\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 14, "IT_HTL_AMENITY", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Htl_Amenity", com.kcdata.abe.bapi.util.Yst_Ota_Htl_AmenityType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Htl_AmenityType(), new java.lang.String[][]{}, "IT_HTL_AMENITY", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_HTL_AMENITY\"><ifr:descriptor><ifr:description language=\"EN\">OTA Hotel Amenity</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_HTL_AMENITY\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_HTL_AMENITY\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Y_Ota_Hotel_Availability_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Y_Ota_Hotel_Availability_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public void setIt_Htl_Pricing(com.kcdata.abe.bapi.util.Yst_Ota_Htl_Room_PricingType_List It_Htl_Pricing) {
        baseTypeData().setElementValue(10, It_Htl_Pricing);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Htl_Room_PricingType_List get_as_listIt_Htl_Pricing() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Htl_Room_PricingType_List)baseTypeData().getElementValue(10);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Htl_AvailabilityType_List get_as_listIt_Htl_Availability() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Htl_AvailabilityType_List)baseTypeData().getElementValue(13);
    }

    public void setIm_Incl_Dummy_Hotels(java.lang.String Im_Incl_Dummy_Hotels) {
        baseTypeData().setElementValue(2, Im_Incl_Dummy_Hotels);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Htl_Req_AmenityType_List get_as_listIt_Htl_Req_Amenity() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Htl_Req_AmenityType_List)baseTypeData().getElementValue(8);
    }

    public void setIt_Return(com.kcdata.abe.bapi.util.Bapiret2Type_List It_Return) {
        baseTypeData().setElementValue(4, It_Return);
    }

    public com.kcdata.abe.bapi.util.Bapiret2Type_List get_as_listIt_Return() {
        return (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(4);
    }

    public void setIm_Application_Info(com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType Im_Application_Info) {
        baseTypeData().setElementValue(1, Im_Application_Info);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Htl_InfoType_List get_as_listIt_Htl_Info() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Htl_InfoType_List)baseTypeData().getElementValue(11);
    }

    public void setIt_Request_Opt(com.kcdata.abe.bapi.util.Yst_Ota_Request_OptType_List It_Request_Opt) {
        baseTypeData().setElementValue(5, It_Request_Opt);
    }

    public void setIt_Htl_Req(com.kcdata.abe.bapi.util.Yst_Ota_Htl_ReqType_List It_Htl_Req) {
        baseTypeData().setElementValue(9, It_Htl_Req);
    }

    public void setIt_Htl_Info(com.kcdata.abe.bapi.util.Yst_Ota_Htl_InfoType_List It_Htl_Info) {
        baseTypeData().setElementValue(11, It_Htl_Info);
    }

    public void setIt_Htl_Vend_Services(com.kcdata.abe.bapi.Yst_Ota_Htl_Vend_ServicesType[] It_Htl_Vend_Services) {
        baseTypeData().setElementValue(6, new com.kcdata.abe.bapi.util.Yst_Ota_Htl_Vend_ServicesType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_Vend_ServicesType_List list$ = get_as_listIt_Htl_Vend_Services();
        for (int  i$ = 0; i$ < It_Htl_Vend_Services.length; i$++){
         list$.addYst_Ota_Htl_Vend_ServicesType(It_Htl_Vend_Services[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Htl_ReqType_List get_as_listIt_Htl_Req() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Htl_ReqType_List)baseTypeData().getElementValue(9);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Htl_Dest_ServicesType_List get_as_listIt_Htl_Dest_Services() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Htl_Dest_ServicesType_List)baseTypeData().getElementValue(12);
    }

    public void setIt_Htl_Dest_Services(com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType[] It_Htl_Dest_Services) {
        baseTypeData().setElementValue(12, new com.kcdata.abe.bapi.util.Yst_Ota_Htl_Dest_ServicesType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_Dest_ServicesType_List list$ = get_as_listIt_Htl_Dest_Services();
        for (int  i$ = 0; i$ < It_Htl_Dest_Services.length; i$++){
         list$.addYst_Ota_Htl_Dest_ServicesType(It_Htl_Dest_Services[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Ota_Request_OptType[] getIt_Request_Opt() {
        com.kcdata.abe.bapi.util.Yst_Ota_Request_OptType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Request_OptType_List)baseTypeData().getElementValue(5);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Request_OptType();
    }

    public java.lang.String getIm_Incl_Dummy_Hotels() {
        return (java.lang.String)baseTypeData().getElementValueAsString(2);
    }

    public void setIm_Req_Hdr(com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType Im_Req_Hdr) {
        baseTypeData().setElementValue(3, Im_Req_Hdr);
    }

    public void setIt_Htl_Req(com.kcdata.abe.bapi.Yst_Ota_Htl_ReqType[] It_Htl_Req) {
        baseTypeData().setElementValue(9, new com.kcdata.abe.bapi.util.Yst_Ota_Htl_ReqType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_ReqType_List list$ = get_as_listIt_Htl_Req();
        for (int  i$ = 0; i$ < It_Htl_Req.length; i$++){
         list$.addYst_Ota_Htl_ReqType(It_Htl_Req[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_AmenityType[] getIt_Htl_Amenity() {
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_AmenityType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Htl_AmenityType_List)baseTypeData().getElementValue(14);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Htl_AmenityType();
    }

    public void setIt_Htl_Amenity(com.kcdata.abe.bapi.util.Yst_Ota_Htl_AmenityType_List It_Htl_Amenity) {
        baseTypeData().setElementValue(14, It_Htl_Amenity);
    }

    public void setIt_Htl_Dest_Services(com.kcdata.abe.bapi.util.Yst_Ota_Htl_Dest_ServicesType_List It_Htl_Dest_Services) {
        baseTypeData().setElementValue(12, It_Htl_Dest_Services);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_Vend_ServicesType[] getIt_Htl_Vend_Services() {
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_Vend_ServicesType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Htl_Vend_ServicesType_List)baseTypeData().getElementValue(6);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Htl_Vend_ServicesType();
    }

    public void setIt_Request_Opt(com.kcdata.abe.bapi.Yst_Ota_Request_OptType[] It_Request_Opt) {
        baseTypeData().setElementValue(5, new com.kcdata.abe.bapi.util.Yst_Ota_Request_OptType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Request_OptType_List list$ = get_as_listIt_Request_Opt();
        for (int  i$ = 0; i$ < It_Request_Opt.length; i$++){
         list$.addYst_Ota_Request_OptType(It_Request_Opt[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_AvailabilityType[] getIt_Htl_Availability() {
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_AvailabilityType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Htl_AvailabilityType_List)baseTypeData().getElementValue(13);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Htl_AvailabilityType();
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List get_as_listIt_Htl_Roomstaycandidates() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List)baseTypeData().getElementValue(7);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType getIm_Req_Hdr() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType)baseTypeData().getElementValue(3);
    }

    public com.kcdata.abe.bapi.Bapiret2Type[] getIt_Return() {
        com.kcdata.abe.bapi.util.Bapiret2Type_List i$ = (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(4);
        if ( i$ == null){return null;}
        return  i$.toArrayBapiret2Type();
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType[] getIt_Htl_Info() {
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_InfoType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Htl_InfoType_List)baseTypeData().getElementValue(11);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Htl_InfoType();
    }

    public void setIt_Htl_Availability(com.kcdata.abe.bapi.util.Yst_Ota_Htl_AvailabilityType_List It_Htl_Availability) {
        baseTypeData().setElementValue(13, It_Htl_Availability);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType[] getIt_Htl_Pricing() {
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_Room_PricingType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Htl_Room_PricingType_List)baseTypeData().getElementValue(10);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Htl_Room_PricingType();
    }

    public void setIt_Htl_Pricing(com.kcdata.abe.bapi.Yst_Ota_Htl_Room_PricingType[] It_Htl_Pricing) {
        baseTypeData().setElementValue(10, new com.kcdata.abe.bapi.util.Yst_Ota_Htl_Room_PricingType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_Room_PricingType_List list$ = get_as_listIt_Htl_Pricing();
        for (int  i$ = 0; i$ < It_Htl_Pricing.length; i$++){
         list$.addYst_Ota_Htl_Room_PricingType(It_Htl_Pricing[ i$]);
        }
    }

    public void setIt_Htl_Info(com.kcdata.abe.bapi.Yst_Ota_Htl_InfoType[] It_Htl_Info) {
        baseTypeData().setElementValue(11, new com.kcdata.abe.bapi.util.Yst_Ota_Htl_InfoType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_InfoType_List list$ = get_as_listIt_Htl_Info();
        for (int  i$ = 0; i$ < It_Htl_Info.length; i$++){
         list$.addYst_Ota_Htl_InfoType(It_Htl_Info[ i$]);
        }
    }

    public void setIt_Htl_Vend_Services(com.kcdata.abe.bapi.util.Yst_Ota_Htl_Vend_ServicesType_List It_Htl_Vend_Services) {
        baseTypeData().setElementValue(6, It_Htl_Vend_Services);
    }

    public void setIt_Htl_Req_Amenity(com.kcdata.abe.bapi.util.Yst_Ota_Htl_Req_AmenityType_List It_Htl_Req_Amenity) {
        baseTypeData().setElementValue(8, It_Htl_Req_Amenity);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_Req_AmenityType[] getIt_Htl_Req_Amenity() {
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_Req_AmenityType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Htl_Req_AmenityType_List)baseTypeData().getElementValue(8);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Htl_Req_AmenityType();
    }

    public void setCh_St_Bapi_Metadata(com.kcdata.abe.bapi.Yst_MetadataType Ch_St_Bapi_Metadata) {
        baseTypeData().setElementValue(0, Ch_St_Bapi_Metadata);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Request_OptType_List get_as_listIt_Request_Opt() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Request_OptType_List)baseTypeData().getElementValue(5);
    }

    public void setIt_Return(com.kcdata.abe.bapi.Bapiret2Type[] It_Return) {
        baseTypeData().setElementValue(4, new com.kcdata.abe.bapi.util.Bapiret2Type_List());
        com.kcdata.abe.bapi.util.Bapiret2Type_List list$ = get_as_listIt_Return();
        for (int  i$ = 0; i$ < It_Return.length; i$++){
         list$.addBapiret2Type(It_Return[ i$]);
        }
    }

    public void setIt_Htl_Req_Amenity(com.kcdata.abe.bapi.Yst_Ota_Htl_Req_AmenityType[] It_Htl_Req_Amenity) {
        baseTypeData().setElementValue(8, new com.kcdata.abe.bapi.util.Yst_Ota_Htl_Req_AmenityType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_Req_AmenityType_List list$ = get_as_listIt_Htl_Req_Amenity();
        for (int  i$ = 0; i$ < It_Htl_Req_Amenity.length; i$++){
         list$.addYst_Ota_Htl_Req_AmenityType(It_Htl_Req_Amenity[ i$]);
        }
    }

    public void setIt_Htl_Amenity(com.kcdata.abe.bapi.Yst_Ota_Htl_AmenityType[] It_Htl_Amenity) {
        baseTypeData().setElementValue(14, new com.kcdata.abe.bapi.util.Yst_Ota_Htl_AmenityType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_AmenityType_List list$ = get_as_listIt_Htl_Amenity();
        for (int  i$ = 0; i$ < It_Htl_Amenity.length; i$++){
         list$.addYst_Ota_Htl_AmenityType(It_Htl_Amenity[ i$]);
        }
    }

    public MetaData metadataY_Ota_Hotel_Availability_Input() {
        return metadata;
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Htl_AmenityType_List get_as_listIt_Htl_Amenity() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Htl_AmenityType_List)baseTypeData().getElementValue(14);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Htl_Vend_ServicesType_List get_as_listIt_Htl_Vend_Services() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Htl_Vend_ServicesType_List)baseTypeData().getElementValue(6);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType getIm_Application_Info() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType)baseTypeData().getElementValue(1);
    }

    public com.kcdata.abe.bapi.Yst_Ota_RoomstaycandidatesType[] getIt_Htl_Roomstaycandidates() {
        com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List)baseTypeData().getElementValue(7);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_RoomstaycandidatesType();
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_ReqType[] getIt_Htl_Req() {
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_ReqType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Htl_ReqType_List)baseTypeData().getElementValue(9);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Htl_ReqType();
    }

    public void setIt_Htl_Availability(com.kcdata.abe.bapi.Yst_Ota_Htl_AvailabilityType[] It_Htl_Availability) {
        baseTypeData().setElementValue(13, new com.kcdata.abe.bapi.util.Yst_Ota_Htl_AvailabilityType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_AvailabilityType_List list$ = get_as_listIt_Htl_Availability();
        for (int  i$ = 0; i$ < It_Htl_Availability.length; i$++){
         list$.addYst_Ota_Htl_AvailabilityType(It_Htl_Availability[ i$]);
        }
    }

    public void setIt_Htl_Roomstaycandidates(com.kcdata.abe.bapi.Yst_Ota_RoomstaycandidatesType[] It_Htl_Roomstaycandidates) {
        baseTypeData().setElementValue(7, new com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List list$ = get_as_listIt_Htl_Roomstaycandidates();
        for (int  i$ = 0; i$ < It_Htl_Roomstaycandidates.length; i$++){
         list$.addYst_Ota_RoomstaycandidatesType(It_Htl_Roomstaycandidates[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_Dest_ServicesType[] getIt_Htl_Dest_Services() {
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_Dest_ServicesType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Htl_Dest_ServicesType_List)baseTypeData().getElementValue(12);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Htl_Dest_ServicesType();
    }

    public void setIt_Htl_Roomstaycandidates(com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List It_Htl_Roomstaycandidates) {
        baseTypeData().setElementValue(7, It_Htl_Roomstaycandidates);
    }

    public com.kcdata.abe.bapi.Yst_MetadataType getCh_St_Bapi_Metadata() {
        return (com.kcdata.abe.bapi.Yst_MetadataType)baseTypeData().getElementValue(0);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Ota_Hotel_Availability_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Ota_Hotel_Availability_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Htl_Availability() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(13);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Req_Hdr() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Htl_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(11);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Htl_Pricing() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(10);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Request_Opt() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Application_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Incl_Dummy_Hotels() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Htl_Roomstaycandidates() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(7);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Htl_Req() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(9);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Htl_Dest_Services() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(12);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Htl_Amenity() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(14);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCh_St_Bapi_Metadata() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Htl_Vend_Services() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(6);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Htl_Req_Amenity() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(8);
        }
    
    }

}
