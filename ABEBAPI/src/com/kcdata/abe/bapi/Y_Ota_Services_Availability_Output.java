package com.kcdata.abe.bapi;
public class Y_Ota_Services_Availability_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1341668210944L) ;

    private  Y_Ota_Services_Availability_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_OTA_SERVICES_AVAILABILITY.Output", 10, 0, com.kcdata.abe.bapi.Y_Ota_Services_Availability_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_OTA_SERVICES_AVAILABILITY", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Suppliments Availability</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "CH_ST_BAPI_METADATA", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_METADATA", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ch_St_Bapi_Metadata", com.kcdata.abe.bapi.Yst_MetadataType.class, new com.kcdata.abe.bapi.Yst_MetadataType(), new java.lang.String[][]{}, "CH_ST_BAPI_METADATA", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER | com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"CH_ST_BAPI_METADATA\"><ifr:descriptor><ifr:description language=\"EN\">Matadata for BAPI Request Interface</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_METADATA\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_METADATA\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>changing</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IT_RETURN", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Return", com.kcdata.abe.bapi.util.Bapiret2Type_List.class, new com.kcdata.abe.bapi.Bapiret2Type(), new java.lang.String[][]{}, "IT_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRET2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRET2\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IT_OTA_SERVICES", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Ota_Services", com.kcdata.abe.bapi.util.Yst_Ota_ServicesType_List.class, new com.kcdata.abe.bapi.Yst_Ota_ServicesType(), new java.lang.String[][]{}, "IT_OTA_SERVICES", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_OTA_SERVICES\"><ifr:descriptor><ifr:description language=\"EN\">OTA Services Offered Vendor</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_SERVICES\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_SERVICES\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "IT_OTA_SEAT_SERVICES", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Ota_Seat_Services", com.kcdata.abe.bapi.util.Yst_Ota_ServicesType_List.class, new com.kcdata.abe.bapi.Yst_Ota_ServicesType(), new java.lang.String[][]{}, "IT_OTA_SEAT_SERVICES", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_OTA_SEAT_SERVICES\"><ifr:descriptor><ifr:description language=\"EN\">OTA  SEAT Services</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_SERVICES\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_SERVICES\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "IT_OTA_HTL_REQ", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Ota_Htl_Req", com.kcdata.abe.bapi.util.Yst_Ota_Htl_ReqType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Htl_ReqType(), new java.lang.String[][]{}, "IT_OTA_HTL_REQ", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_OTA_HTL_REQ\"><ifr:descriptor><ifr:description language=\"EN\">OTA Hotel Request</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_HTL_REQ\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_HTL_REQ\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 5, "IT_OTA_HTL_ITEMS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Ota_Htl_Items", com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType(), new java.lang.String[][]{}, "IT_OTA_HTL_ITEMS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_OTA_HTL_ITEMS\"><ifr:descriptor><ifr:description language=\"EN\">OTA Hotel items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_HTL_ITEMS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_HTL_ITEMS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 6, "IT_OTA_GUESTINFO", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Ota_Guestinfo", com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List.class, new com.kcdata.abe.bapi.Yst_Ota_GuestinfoType(), new java.lang.String[][]{}, "IT_OTA_GUESTINFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_OTA_GUESTINFO\"><ifr:descriptor><ifr:description language=\"EN\">OTA Passenger Information</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_GUESTINFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_GUESTINFO\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 7, "IT_OTA_FLT_SEGMENTS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Ota_Flt_Segments", com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Flt_SegmentsType(), new java.lang.String[][]{}, "IT_OTA_FLT_SEGMENTS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_OTA_FLT_SEGMENTS\"><ifr:descriptor><ifr:description language=\"EN\">Flight Segments</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_FLT_SEGMENTS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_FLT_SEGMENTS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 8, "IT_OTA_FLT_REQ", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Ota_Flt_Req", com.kcdata.abe.bapi.util.Yst_Ota_Flt_ReqType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Flt_ReqType(), new java.lang.String[][]{}, "IT_OTA_FLT_REQ", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_OTA_FLT_REQ\"><ifr:descriptor><ifr:description language=\"EN\">OTA Flight Request</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_FLT_REQ\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_FLT_REQ\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 9, "IT_OTA_FLT_ITEMS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Ota_Flt_Items", com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Flt_ItemsType(), new java.lang.String[][]{}, "IT_OTA_FLT_ITEMS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_OTA_FLT_ITEMS\"><ifr:descriptor><ifr:description language=\"EN\">OTA Fligth Items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_FLT_ITEMS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_FLT_ITEMS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    protected  Y_Ota_Services_Availability_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Y_Ota_Services_Availability_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Flt_ReqType_List get_as_listIt_Ota_Flt_Req() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Flt_ReqType_List)baseTypeData().getElementValue(8);
    }

    public void setIt_Ota_Guestinfo(com.kcdata.abe.bapi.Yst_Ota_GuestinfoType[] It_Ota_Guestinfo) {
        baseTypeData().setElementValue(6, new com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List list$ = get_as_listIt_Ota_Guestinfo();
        for (int  i$ = 0; i$ < It_Ota_Guestinfo.length; i$++){
         list$.addYst_Ota_GuestinfoType(It_Ota_Guestinfo[ i$]);
        }
    }

    public void setIt_Ota_Services(com.kcdata.abe.bapi.util.Yst_Ota_ServicesType_List It_Ota_Services) {
        baseTypeData().setElementValue(2, It_Ota_Services);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List get_as_listIt_Ota_Guestinfo() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List)baseTypeData().getElementValue(6);
    }

    public com.kcdata.abe.bapi.Bapiret2Type[] getIt_Return() {
        com.kcdata.abe.bapi.util.Bapiret2Type_List i$ = (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayBapiret2Type();
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_ReqType[] getIt_Ota_Flt_Req() {
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_ReqType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Flt_ReqType_List)baseTypeData().getElementValue(8);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Flt_ReqType();
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Htl_ReqType_List get_as_listIt_Ota_Htl_Req() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Htl_ReqType_List)baseTypeData().getElementValue(4);
    }

    public void setIt_Ota_Flt_Req(com.kcdata.abe.bapi.Yst_Ota_Flt_ReqType[] It_Ota_Flt_Req) {
        baseTypeData().setElementValue(8, new com.kcdata.abe.bapi.util.Yst_Ota_Flt_ReqType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_ReqType_List list$ = get_as_listIt_Ota_Flt_Req();
        for (int  i$ = 0; i$ < It_Ota_Flt_Req.length; i$++){
         list$.addYst_Ota_Flt_ReqType(It_Ota_Flt_Req[ i$]);
        }
    }

    public void setIt_Return(com.kcdata.abe.bapi.util.Bapiret2Type_List It_Return) {
        baseTypeData().setElementValue(1, It_Return);
    }

    public com.kcdata.abe.bapi.Yst_Ota_GuestinfoType[] getIt_Ota_Guestinfo() {
        com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List)baseTypeData().getElementValue(6);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_GuestinfoType();
    }

    public void setIt_Ota_Flt_Items(com.kcdata.abe.bapi.Yst_Ota_Flt_ItemsType[] It_Ota_Flt_Items) {
        baseTypeData().setElementValue(9, new com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List list$ = get_as_listIt_Ota_Flt_Items();
        for (int  i$ = 0; i$ < It_Ota_Flt_Items.length; i$++){
         list$.addYst_Ota_Flt_ItemsType(It_Ota_Flt_Items[ i$]);
        }
    }

    public void setIt_Ota_Flt_Segments(com.kcdata.abe.bapi.Yst_Ota_Flt_SegmentsType[] It_Ota_Flt_Segments) {
        baseTypeData().setElementValue(7, new com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List list$ = get_as_listIt_Ota_Flt_Segments();
        for (int  i$ = 0; i$ < It_Ota_Flt_Segments.length; i$++){
         list$.addYst_Ota_Flt_SegmentsType(It_Ota_Flt_Segments[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_ServicesType_List get_as_listIt_Ota_Seat_Services() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_ServicesType_List)baseTypeData().getElementValue(3);
    }

    public com.kcdata.abe.bapi.util.Bapiret2Type_List get_as_listIt_Return() {
        return (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(1);
    }

    public void setIt_Ota_Flt_Items(com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List It_Ota_Flt_Items) {
        baseTypeData().setElementValue(9, It_Ota_Flt_Items);
    }

    public void setIt_Ota_Flt_Req(com.kcdata.abe.bapi.util.Yst_Ota_Flt_ReqType_List It_Ota_Flt_Req) {
        baseTypeData().setElementValue(8, It_Ota_Flt_Req);
    }

    public com.kcdata.abe.bapi.Yst_Ota_ServicesType[] getIt_Ota_Services() {
        com.kcdata.abe.bapi.util.Yst_Ota_ServicesType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_ServicesType_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_ServicesType();
    }

    public void setIt_Ota_Htl_Req(com.kcdata.abe.bapi.util.Yst_Ota_Htl_ReqType_List It_Ota_Htl_Req) {
        baseTypeData().setElementValue(4, It_Ota_Htl_Req);
    }

    public void setIt_Ota_Htl_Items(com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List It_Ota_Htl_Items) {
        baseTypeData().setElementValue(5, It_Ota_Htl_Items);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_ReqType[] getIt_Ota_Htl_Req() {
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_ReqType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Htl_ReqType_List)baseTypeData().getElementValue(4);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Htl_ReqType();
    }

    public MetaData metadataY_Ota_Services_Availability_Output() {
        return metadata;
    }

    public void setIt_Ota_Flt_Segments(com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List It_Ota_Flt_Segments) {
        baseTypeData().setElementValue(7, It_Ota_Flt_Segments);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List get_as_listIt_Ota_Flt_Items() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List)baseTypeData().getElementValue(9);
    }

    public com.kcdata.abe.bapi.Yst_Ota_ServicesType[] getIt_Ota_Seat_Services() {
        com.kcdata.abe.bapi.util.Yst_Ota_ServicesType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_ServicesType_List)baseTypeData().getElementValue(3);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_ServicesType();
    }

    public void setCh_St_Bapi_Metadata(com.kcdata.abe.bapi.Yst_MetadataType Ch_St_Bapi_Metadata) {
        baseTypeData().setElementValue(0, Ch_St_Bapi_Metadata);
    }

    public void setIt_Ota_Seat_Services(com.kcdata.abe.bapi.Yst_Ota_ServicesType[] It_Ota_Seat_Services) {
        baseTypeData().setElementValue(3, new com.kcdata.abe.bapi.util.Yst_Ota_ServicesType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_ServicesType_List list$ = get_as_listIt_Ota_Seat_Services();
        for (int  i$ = 0; i$ < It_Ota_Seat_Services.length; i$++){
         list$.addYst_Ota_ServicesType(It_Ota_Seat_Services[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_ServicesType_List get_as_listIt_Ota_Services() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_ServicesType_List)baseTypeData().getElementValue(2);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_SegmentsType[] getIt_Ota_Flt_Segments() {
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List)baseTypeData().getElementValue(7);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Flt_SegmentsType();
    }

    public void setIt_Return(com.kcdata.abe.bapi.Bapiret2Type[] It_Return) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.Bapiret2Type_List());
        com.kcdata.abe.bapi.util.Bapiret2Type_List list$ = get_as_listIt_Return();
        for (int  i$ = 0; i$ < It_Return.length; i$++){
         list$.addBapiret2Type(It_Return[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_ItemsType[] getIt_Ota_Flt_Items() {
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List)baseTypeData().getElementValue(9);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Flt_ItemsType();
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List get_as_listIt_Ota_Htl_Items() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List)baseTypeData().getElementValue(5);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List get_as_listIt_Ota_Flt_Segments() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List)baseTypeData().getElementValue(7);
    }

    public void setIt_Ota_Seat_Services(com.kcdata.abe.bapi.util.Yst_Ota_ServicesType_List It_Ota_Seat_Services) {
        baseTypeData().setElementValue(3, It_Ota_Seat_Services);
    }

    public void setIt_Ota_Services(com.kcdata.abe.bapi.Yst_Ota_ServicesType[] It_Ota_Services) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.Yst_Ota_ServicesType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_ServicesType_List list$ = get_as_listIt_Ota_Services();
        for (int  i$ = 0; i$ < It_Ota_Services.length; i$++){
         list$.addYst_Ota_ServicesType(It_Ota_Services[ i$]);
        }
    }

    public void setIt_Ota_Htl_Req(com.kcdata.abe.bapi.Yst_Ota_Htl_ReqType[] It_Ota_Htl_Req) {
        baseTypeData().setElementValue(4, new com.kcdata.abe.bapi.util.Yst_Ota_Htl_ReqType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_ReqType_List list$ = get_as_listIt_Ota_Htl_Req();
        for (int  i$ = 0; i$ < It_Ota_Htl_Req.length; i$++){
         list$.addYst_Ota_Htl_ReqType(It_Ota_Htl_Req[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType[] getIt_Ota_Htl_Items() {
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List)baseTypeData().getElementValue(5);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Htl_ItemsType();
    }

    public void setIt_Ota_Htl_Items(com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType[] It_Ota_Htl_Items) {
        baseTypeData().setElementValue(5, new com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List list$ = get_as_listIt_Ota_Htl_Items();
        for (int  i$ = 0; i$ < It_Ota_Htl_Items.length; i$++){
         list$.addYst_Ota_Htl_ItemsType(It_Ota_Htl_Items[ i$]);
        }
    }

    public void setIt_Ota_Guestinfo(com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List It_Ota_Guestinfo) {
        baseTypeData().setElementValue(6, It_Ota_Guestinfo);
    }

    public com.kcdata.abe.bapi.Yst_MetadataType getCh_St_Bapi_Metadata() {
        return (com.kcdata.abe.bapi.Yst_MetadataType)baseTypeData().getElementValue(0);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Ota_Services_Availability_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Ota_Services_Availability_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Ota_Seat_Services() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Ota_Guestinfo() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(6);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Ota_Flt_Segments() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(7);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Ota_Htl_Items() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Ota_Services() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Ota_Flt_Items() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(9);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Ota_Htl_Req() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Ota_Flt_Req() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(8);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCh_St_Bapi_Metadata() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
