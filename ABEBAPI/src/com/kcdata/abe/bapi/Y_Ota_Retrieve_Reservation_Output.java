package com.kcdata.abe.bapi;
public class Y_Ota_Retrieve_Reservation_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1341668166188L) ;

    private  Y_Ota_Retrieve_Reservation_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_OTA_RETRIEVE_RESERVATION.Output", 14, 0, com.kcdata.abe.bapi.Y_Ota_Retrieve_Reservation_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_OTA_RETRIEVE_RESERVATION", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Retrieve Reservation</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "CH_ST_BAPI_METADATA", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_METADATA", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ch_St_Bapi_Metadata", com.kcdata.abe.bapi.Yst_MetadataType.class, new com.kcdata.abe.bapi.Yst_MetadataType(), new java.lang.String[][]{}, "CH_ST_BAPI_METADATA", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER | com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"CH_ST_BAPI_METADATA\"><ifr:descriptor><ifr:description language=\"EN\">Matadata for BAPI Request Interface</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_METADATA\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_METADATA\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>changing</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "EX_ST_RES_STATUS", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_RES_STATUS", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ex_St_Res_Status", com.kcdata.abe.bapi.Yst_Res_StatusType.class, new com.kcdata.abe.bapi.Yst_Res_StatusType(), new java.lang.String[][]{}, "EX_ST_RES_STATUS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"EX_ST_RES_STATUS\"><ifr:descriptor><ifr:description language=\"EN\">Sales order status info</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_RES_STATUS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_RES_STATUS\" /></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IT_VENDOR_INFO", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Vendor_Info", com.kcdata.abe.bapi.util.Zapi_VendaddrType_List.class, new com.kcdata.abe.bapi.Zapi_VendaddrType(), new java.lang.String[][]{}, "IT_VENDOR_INFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_VENDOR_INFO\"><ifr:descriptor><ifr:description language=\"EN\">vender address</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_VENDADDR\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_VENDADDR\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "IT_SEATMAP", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Seatmap", com.kcdata.abe.bapi.util.Yzseat_Info_SType_List.class, new com.kcdata.abe.bapi.Yzseat_Info_SType(), new java.lang.String[][]{}, "IT_SEATMAP", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_SEATMAP\"><ifr:descriptor><ifr:description language=\"EN\">seat details</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YZSEAT_INFO_S\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YZSEAT_INFO_S\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "IT_RETURN", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Return", com.kcdata.abe.bapi.util.Bapiret2Type_List.class, new com.kcdata.abe.bapi.Bapiret2Type(), new java.lang.String[][]{}, "IT_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRET2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRET2\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 5, "IT_RES_VEH", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Res_Veh", com.kcdata.abe.bapi.util.Yst_Ota_Res_VehType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Res_VehType(), new java.lang.String[][]{}, "IT_RES_VEH", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RES_VEH\"><ifr:descriptor><ifr:description language=\"EN\">Vehicle Items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_RES_VEH\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_RES_VEH\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 6, "IT_RES_SER", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Res_Ser", com.kcdata.abe.bapi.util.Yst_Ota_Res_SerType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Res_SerType(), new java.lang.String[][]{}, "IT_RES_SER", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RES_SER\"><ifr:descriptor><ifr:description language=\"EN\">Services items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_RES_SER\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_RES_SER\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 7, "IT_RES_INS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Res_Ins", com.kcdata.abe.bapi.util.Yst_Bapi_Res_InsType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_Res_InsType(), new java.lang.String[][]{}, "IT_RES_INS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RES_INS\"><ifr:descriptor><ifr:description language=\"EN\">Insurance items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_RES_INS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_RES_INS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 8, "IT_RES_HOTELS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Res_Hotels", com.kcdata.abe.bapi.util.Yst_Ota_Res_HotelsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType(), new java.lang.String[][]{}, "IT_RES_HOTELS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RES_HOTELS\"><ifr:descriptor><ifr:description language=\"EN\">Hotel items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_RES_HOTELS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_RES_HOTELS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 9, "IT_RES_FLIGHTS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Res_Flights", com.kcdata.abe.bapi.util.Yst_Ota_Res_FlightsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType(), new java.lang.String[][]{}, "IT_RES_FLIGHTS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RES_FLIGHTS\"><ifr:descriptor><ifr:description language=\"EN\">Flight Items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_RES_FLIGHTS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_RES_FLIGHTS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 10, "IT_PAX_PRICING", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Pax_Pricing", com.kcdata.abe.bapi.util.Yst_Ota_Pax_PricingType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType(), new java.lang.String[][]{}, "IT_PAX_PRICING", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_PAX_PRICING\"><ifr:descriptor><ifr:description language=\"EN\">OTA  Pax Pricing</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_PAX_PRICING\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_PAX_PRICING\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 11, "IT_GUESTINFO", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Guestinfo", com.kcdata.abe.bapi.util.Yst_Ota_Res_GuestinfoType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType(), new java.lang.String[][]{}, "IT_GUESTINFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_GUESTINFO\"><ifr:descriptor><ifr:description language=\"EN\">OTA Passenger Information</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_RES_GUESTINFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_RES_GUESTINFO\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 12, "IT_FLIGHT_SEGMENTS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Flight_Segments", com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Flt_SegmentsType(), new java.lang.String[][]{}, "IT_FLIGHT_SEGMENTS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_FLIGHT_SEGMENTS\"><ifr:descriptor><ifr:description language=\"EN\">Flight Segments</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_FLT_SEGMENTS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_FLT_SEGMENTS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 13, "IT_CHARGES", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Charges", com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List.class, new com.kcdata.abe.bapi.Yst_Ota_ChargesType(), new java.lang.String[][]{}, "IT_CHARGES", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_CHARGES\"><ifr:descriptor><ifr:description language=\"EN\">OTA Booking Charges</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_CHARGES\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_CHARGES\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Y_Ota_Retrieve_Reservation_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Y_Ota_Retrieve_Reservation_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public void setIt_Res_Flights(com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType[] It_Res_Flights) {
        baseTypeData().setElementValue(9, new com.kcdata.abe.bapi.util.Yst_Ota_Res_FlightsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Res_FlightsType_List list$ = get_as_listIt_Res_Flights();
        for (int  i$ = 0; i$ < It_Res_Flights.length; i$++){
         list$.addYst_Ota_Res_FlightsType(It_Res_Flights[ i$]);
        }
    }

    public void setIt_Vendor_Info(com.kcdata.abe.bapi.util.Zapi_VendaddrType_List It_Vendor_Info) {
        baseTypeData().setElementValue(2, It_Vendor_Info);
    }

    public void setIt_Guestinfo(com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType[] It_Guestinfo) {
        baseTypeData().setElementValue(11, new com.kcdata.abe.bapi.util.Yst_Ota_Res_GuestinfoType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Res_GuestinfoType_List list$ = get_as_listIt_Guestinfo();
        for (int  i$ = 0; i$ < It_Guestinfo.length; i$++){
         list$.addYst_Ota_Res_GuestinfoType(It_Guestinfo[ i$]);
        }
    }

    public void setIt_Flight_Segments(com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List It_Flight_Segments) {
        baseTypeData().setElementValue(12, It_Flight_Segments);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List get_as_listIt_Charges() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List)baseTypeData().getElementValue(13);
    }

    public void setIt_Return(com.kcdata.abe.bapi.util.Bapiret2Type_List It_Return) {
        baseTypeData().setElementValue(4, It_Return);
    }

    public void setIt_Res_Ins(com.kcdata.abe.bapi.util.Yst_Bapi_Res_InsType_List It_Res_Ins) {
        baseTypeData().setElementValue(7, It_Res_Ins);
    }

    public com.kcdata.abe.bapi.util.Yzseat_Info_SType_List get_as_listIt_Seatmap() {
        return (com.kcdata.abe.bapi.util.Yzseat_Info_SType_List)baseTypeData().getElementValue(3);
    }

    public void setIt_Seatmap(com.kcdata.abe.bapi.Yzseat_Info_SType[] It_Seatmap) {
        baseTypeData().setElementValue(3, new com.kcdata.abe.bapi.util.Yzseat_Info_SType_List());
        com.kcdata.abe.bapi.util.Yzseat_Info_SType_List list$ = get_as_listIt_Seatmap();
        for (int  i$ = 0; i$ < It_Seatmap.length; i$++){
         list$.addYzseat_Info_SType(It_Seatmap[ i$]);
        }
    }

    public void setIt_Pax_Pricing(com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType[] It_Pax_Pricing) {
        baseTypeData().setElementValue(10, new com.kcdata.abe.bapi.util.Yst_Ota_Pax_PricingType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Pax_PricingType_List list$ = get_as_listIt_Pax_Pricing();
        for (int  i$ = 0; i$ < It_Pax_Pricing.length; i$++){
         list$.addYst_Ota_Pax_PricingType(It_Pax_Pricing[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Bapiret2Type_List get_as_listIt_Return() {
        return (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(4);
    }

    public void setIt_Vendor_Info(com.kcdata.abe.bapi.Zapi_VendaddrType[] It_Vendor_Info) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.Zapi_VendaddrType_List());
        com.kcdata.abe.bapi.util.Zapi_VendaddrType_List list$ = get_as_listIt_Vendor_Info();
        for (int  i$ = 0; i$ < It_Vendor_Info.length; i$++){
         list$.addZapi_VendaddrType(It_Vendor_Info[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_Res_InsType_List get_as_listIt_Res_Ins() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_Res_InsType_List)baseTypeData().getElementValue(7);
    }

    public void setIt_Guestinfo(com.kcdata.abe.bapi.util.Yst_Ota_Res_GuestinfoType_List It_Guestinfo) {
        baseTypeData().setElementValue(11, It_Guestinfo);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List get_as_listIt_Flight_Segments() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List)baseTypeData().getElementValue(12);
    }

    public void setIt_Charges(com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List It_Charges) {
        baseTypeData().setElementValue(13, It_Charges);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_VehType[] getIt_Res_Veh() {
        com.kcdata.abe.bapi.util.Yst_Ota_Res_VehType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Res_VehType_List)baseTypeData().getElementValue(5);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Res_VehType();
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Pax_PricingType_List get_as_listIt_Pax_Pricing() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Pax_PricingType_List)baseTypeData().getElementValue(10);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Res_GuestinfoType_List get_as_listIt_Guestinfo() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Res_GuestinfoType_List)baseTypeData().getElementValue(11);
    }

    public com.kcdata.abe.bapi.util.Zapi_VendaddrType_List get_as_listIt_Vendor_Info() {
        return (com.kcdata.abe.bapi.util.Zapi_VendaddrType_List)baseTypeData().getElementValue(2);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Res_FlightsType_List get_as_listIt_Res_Flights() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Res_FlightsType_List)baseTypeData().getElementValue(9);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Res_HotelsType_List get_as_listIt_Res_Hotels() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Res_HotelsType_List)baseTypeData().getElementValue(8);
    }

    public void setIt_Res_Veh(com.kcdata.abe.bapi.Yst_Ota_Res_VehType[] It_Res_Veh) {
        baseTypeData().setElementValue(5, new com.kcdata.abe.bapi.util.Yst_Ota_Res_VehType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Res_VehType_List list$ = get_as_listIt_Res_Veh();
        for (int  i$ = 0; i$ < It_Res_Veh.length; i$++){
         list$.addYst_Ota_Res_VehType(It_Res_Veh[ i$]);
        }
    }

    public void setEx_St_Res_Status(com.kcdata.abe.bapi.Yst_Res_StatusType Ex_St_Res_Status) {
        baseTypeData().setElementValue(1, Ex_St_Res_Status);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_SerType[] getIt_Res_Ser() {
        com.kcdata.abe.bapi.util.Yst_Ota_Res_SerType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Res_SerType_List)baseTypeData().getElementValue(6);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Res_SerType();
    }

    public void setIt_Res_Hotels(com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType[] It_Res_Hotels) {
        baseTypeData().setElementValue(8, new com.kcdata.abe.bapi.util.Yst_Ota_Res_HotelsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Res_HotelsType_List list$ = get_as_listIt_Res_Hotels();
        for (int  i$ = 0; i$ < It_Res_Hotels.length; i$++){
         list$.addYst_Ota_Res_HotelsType(It_Res_Hotels[ i$]);
        }
    }

    public MetaData metadataY_Ota_Retrieve_Reservation_Output() {
        return metadata;
    }

    public void setIt_Res_Ser(com.kcdata.abe.bapi.Yst_Ota_Res_SerType[] It_Res_Ser) {
        baseTypeData().setElementValue(6, new com.kcdata.abe.bapi.util.Yst_Ota_Res_SerType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Res_SerType_List list$ = get_as_listIt_Res_Ser();
        for (int  i$ = 0; i$ < It_Res_Ser.length; i$++){
         list$.addYst_Ota_Res_SerType(It_Res_Ser[ i$]);
        }
    }

    public void setIt_Res_Veh(com.kcdata.abe.bapi.util.Yst_Ota_Res_VehType_List It_Res_Veh) {
        baseTypeData().setElementValue(5, It_Res_Veh);
    }

    public void setIt_Pax_Pricing(com.kcdata.abe.bapi.util.Yst_Ota_Pax_PricingType_List It_Pax_Pricing) {
        baseTypeData().setElementValue(10, It_Pax_Pricing);
    }

    public com.kcdata.abe.bapi.Yst_Res_StatusType getEx_St_Res_Status() {
        return (com.kcdata.abe.bapi.Yst_Res_StatusType)baseTypeData().getElementValue(1);
    }

    public void setIt_Res_Hotels(com.kcdata.abe.bapi.util.Yst_Ota_Res_HotelsType_List It_Res_Hotels) {
        baseTypeData().setElementValue(8, It_Res_Hotels);
    }

    public com.kcdata.abe.bapi.Bapiret2Type[] getIt_Return() {
        com.kcdata.abe.bapi.util.Bapiret2Type_List i$ = (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(4);
        if ( i$ == null){return null;}
        return  i$.toArrayBapiret2Type();
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Res_VehType_List get_as_listIt_Res_Veh() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Res_VehType_List)baseTypeData().getElementValue(5);
    }

    public com.kcdata.abe.bapi.Yst_Ota_ChargesType[] getIt_Charges() {
        com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List)baseTypeData().getElementValue(13);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_ChargesType();
    }

    public void setIt_Res_Ser(com.kcdata.abe.bapi.util.Yst_Ota_Res_SerType_List It_Res_Ser) {
        baseTypeData().setElementValue(6, It_Res_Ser);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType[] getIt_Res_Hotels() {
        com.kcdata.abe.bapi.util.Yst_Ota_Res_HotelsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Res_HotelsType_List)baseTypeData().getElementValue(8);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Res_HotelsType();
    }

    public com.kcdata.abe.bapi.Yzseat_Info_SType[] getIt_Seatmap() {
        com.kcdata.abe.bapi.util.Yzseat_Info_SType_List i$ = (com.kcdata.abe.bapi.util.Yzseat_Info_SType_List)baseTypeData().getElementValue(3);
        if ( i$ == null){return null;}
        return  i$.toArrayYzseat_Info_SType();
    }

    public void setCh_St_Bapi_Metadata(com.kcdata.abe.bapi.Yst_MetadataType Ch_St_Bapi_Metadata) {
        baseTypeData().setElementValue(0, Ch_St_Bapi_Metadata);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Res_InsType[] getIt_Res_Ins() {
        com.kcdata.abe.bapi.util.Yst_Bapi_Res_InsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_Res_InsType_List)baseTypeData().getElementValue(7);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_Res_InsType();
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_SegmentsType[] getIt_Flight_Segments() {
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List)baseTypeData().getElementValue(12);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Flt_SegmentsType();
    }

    public void setIt_Return(com.kcdata.abe.bapi.Bapiret2Type[] It_Return) {
        baseTypeData().setElementValue(4, new com.kcdata.abe.bapi.util.Bapiret2Type_List());
        com.kcdata.abe.bapi.util.Bapiret2Type_List list$ = get_as_listIt_Return();
        for (int  i$ = 0; i$ < It_Return.length; i$++){
         list$.addBapiret2Type(It_Return[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Ota_Pax_PricingType[] getIt_Pax_Pricing() {
        com.kcdata.abe.bapi.util.Yst_Ota_Pax_PricingType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Pax_PricingType_List)baseTypeData().getElementValue(10);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Pax_PricingType();
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Res_SerType_List get_as_listIt_Res_Ser() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Res_SerType_List)baseTypeData().getElementValue(6);
    }

    public void setIt_Seatmap(com.kcdata.abe.bapi.util.Yzseat_Info_SType_List It_Seatmap) {
        baseTypeData().setElementValue(3, It_Seatmap);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_GuestinfoType[] getIt_Guestinfo() {
        com.kcdata.abe.bapi.util.Yst_Ota_Res_GuestinfoType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Res_GuestinfoType_List)baseTypeData().getElementValue(11);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Res_GuestinfoType();
    }

    public com.kcdata.abe.bapi.Zapi_VendaddrType[] getIt_Vendor_Info() {
        com.kcdata.abe.bapi.util.Zapi_VendaddrType_List i$ = (com.kcdata.abe.bapi.util.Zapi_VendaddrType_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_VendaddrType();
    }

    public void setIt_Res_Ins(com.kcdata.abe.bapi.Yst_Bapi_Res_InsType[] It_Res_Ins) {
        baseTypeData().setElementValue(7, new com.kcdata.abe.bapi.util.Yst_Bapi_Res_InsType_List());
        com.kcdata.abe.bapi.util.Yst_Bapi_Res_InsType_List list$ = get_as_listIt_Res_Ins();
        for (int  i$ = 0; i$ < It_Res_Ins.length; i$++){
         list$.addYst_Bapi_Res_InsType(It_Res_Ins[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_FlightsType[] getIt_Res_Flights() {
        com.kcdata.abe.bapi.util.Yst_Ota_Res_FlightsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Res_FlightsType_List)baseTypeData().getElementValue(9);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Res_FlightsType();
    }

    public void setIt_Charges(com.kcdata.abe.bapi.Yst_Ota_ChargesType[] It_Charges) {
        baseTypeData().setElementValue(13, new com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_ChargesType_List list$ = get_as_listIt_Charges();
        for (int  i$ = 0; i$ < It_Charges.length; i$++){
         list$.addYst_Ota_ChargesType(It_Charges[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_MetadataType getCh_St_Bapi_Metadata() {
        return (com.kcdata.abe.bapi.Yst_MetadataType)baseTypeData().getElementValue(0);
    }

    public void setIt_Res_Flights(com.kcdata.abe.bapi.util.Yst_Ota_Res_FlightsType_List It_Res_Flights) {
        baseTypeData().setElementValue(9, It_Res_Flights);
    }

    public void setIt_Flight_Segments(com.kcdata.abe.bapi.Yst_Ota_Flt_SegmentsType[] It_Flight_Segments) {
        baseTypeData().setElementValue(12, new com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List list$ = get_as_listIt_Flight_Segments();
        for (int  i$ = 0; i$ < It_Flight_Segments.length; i$++){
         list$.addYst_Ota_Flt_SegmentsType(It_Flight_Segments[ i$]);
        }
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Ota_Retrieve_Reservation_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Ota_Retrieve_Reservation_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getEx_St_Res_Status() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Seatmap() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Flight_Segments() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(12);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Res_Ins() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(7);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Pax_Pricing() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(10);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Guestinfo() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(11);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Vendor_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Res_Flights() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(9);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Res_Ser() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(6);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Charges() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(13);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCh_St_Bapi_Metadata() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Res_Veh() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Res_Hotels() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(8);
        }
    
    }

}
