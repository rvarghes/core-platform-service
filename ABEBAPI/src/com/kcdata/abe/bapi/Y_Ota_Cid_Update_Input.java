package com.kcdata.abe.bapi;
public class Y_Ota_Cid_Update_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1396186757452L) ;

    private  Y_Ota_Cid_Update_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_OTA_CID_UPDATE.Input", 16, 0, com.kcdata.abe.bapi.Y_Ota_Cid_Update_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_OTA_CID_UPDATE", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">After Booking bapi secondary call for Z table updates</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "CH_ST_BAPI_METADATA", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_METADATA", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ch_St_Bapi_Metadata", com.kcdata.abe.bapi.Yst_MetadataType.class, new com.kcdata.abe.bapi.Yst_MetadataType(), new java.lang.String[][]{}, "CH_ST_BAPI_METADATA", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER | com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"CH_ST_BAPI_METADATA\"><ifr:descriptor><ifr:description language=\"EN\">Matadata for BAPI Request Interface</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_METADATA\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_METADATA\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>changing</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IM_BAPI_REQ_HDR", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_REQ_HDR", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Bapi_Req_Hdr", com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType.class, new com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType(), new java.lang.String[][]{}, "IM_BAPI_REQ_HDR", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_BAPI_REQ_HDR\"><ifr:descriptor><ifr:description language=\"EN\">Hotel Request Header</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_REQ_HDR\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_REQ_HDR\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IM_ST_APPLI_INFO", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_APPLI_INFO", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_St_Appli_Info", com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType.class, new com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType(), new java.lang.String[][]{}, "IM_ST_APPLI_INFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_ST_APPLI_INFO\"><ifr:descriptor><ifr:description language=\"EN\">BAPI Application Info</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_APPLI_INFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_APPLI_INFO\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "IT_VEH_ITEMS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Veh_Items", com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Veh_ItemsType(), new java.lang.String[][]{}, "IT_VEH_ITEMS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_VEH_ITEMS\"><ifr:descriptor><ifr:description language=\"EN\">OTA Vehicle items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_VEH_ITEMS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_VEH_ITEMS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "IT_TRN_ITEMS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Trn_Items", com.kcdata.abe.bapi.util.Yst_Bapi_Trn_ItemsType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_Trn_ItemsType(), new java.lang.String[][]{}, "IT_TRN_ITEMS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_TRN_ITEMS\"><ifr:descriptor><ifr:description language=\"EN\">BAPI Transfer Items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_TRN_ITEMS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_TRN_ITEMS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 5, "IT_TRN_HDR", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Trn_Hdr", com.kcdata.abe.bapi.util.Yst_Bapi_Trn_HdrType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType(), new java.lang.String[][]{}, "IT_TRN_HDR", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_TRN_HDR\"><ifr:descriptor><ifr:description language=\"EN\">BAPI Transfer header</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_TRN_HDR\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_TRN_HDR\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 6, "IT_TRN_GENINFO", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Trn_Geninfo", com.kcdata.abe.bapi.util.Yst_Bapi_Trn_GeninfoType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_Trn_GeninfoType(), new java.lang.String[][]{}, "IT_TRN_GENINFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_TRN_GENINFO\"><ifr:descriptor><ifr:description language=\"EN\">BAPI Transfer Genaral data</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_TRN_GENINFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_TRN_GENINFO\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 7, "IT_SER_ITEMS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Ser_Items", com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Ser_ItemsType(), new java.lang.String[][]{}, "IT_SER_ITEMS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_SER_ITEMS\"><ifr:descriptor><ifr:description language=\"EN\">OTA Services items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_SER_ITEMS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_SER_ITEMS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 8, "IT_SEATMAP", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Seatmap", com.kcdata.abe.bapi.util.Yzseat_Info_SType_List.class, new com.kcdata.abe.bapi.Yzseat_Info_SType(), new java.lang.String[][]{}, "IT_SEATMAP", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_SEATMAP\"><ifr:descriptor><ifr:description language=\"EN\">seat details</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YZSEAT_INFO_S\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YZSEAT_INFO_S\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 9, "IT_RETURN", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Return", com.kcdata.abe.bapi.util.Bapiret2Type_List.class, new com.kcdata.abe.bapi.Bapiret2Type(), new java.lang.String[][]{}, "IT_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRET2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRET2\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 10, "IT_INS_ITEMS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Ins_Items", com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType(), new java.lang.String[][]{}, "IT_INS_ITEMS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_INS_ITEMS\"><ifr:descriptor><ifr:description language=\"EN\">BAPI AVOK Insurance Items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_INS_ITEMS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_INS_ITEMS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 11, "IT_HTL_ROOMSTAYCANDIDATES", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Htl_Roomstaycandidates", com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List.class, new com.kcdata.abe.bapi.Yst_Ota_RoomstaycandidatesType(), new java.lang.String[][]{}, "IT_HTL_ROOMSTAYCANDIDATES", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_HTL_ROOMSTAYCANDIDATES\"><ifr:descriptor><ifr:description language=\"EN\">OTA  Roomstay Candidates</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_ROOMSTAYCANDIDATES\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_ROOMSTAYCANDIDATES\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 12, "IT_HTL_ITEMS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Htl_Items", com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType(), new java.lang.String[][]{}, "IT_HTL_ITEMS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_HTL_ITEMS\"><ifr:descriptor><ifr:description language=\"EN\">Hotel items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_HTL_ITEMS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_HTL_ITEMS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 13, "IT_GUESTINFO", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Guestinfo", com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List.class, new com.kcdata.abe.bapi.Yst_Ota_GuestinfoType(), new java.lang.String[][]{}, "IT_GUESTINFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_GUESTINFO\"><ifr:descriptor><ifr:description language=\"EN\">OTA Passenger Information</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_GUESTINFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_GUESTINFO\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 14, "IT_FLT_SEGMENTS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Flt_Segments", com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Flt_SegmentsType(), new java.lang.String[][]{}, "IT_FLT_SEGMENTS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_FLT_SEGMENTS\"><ifr:descriptor><ifr:description language=\"EN\">Flight Segments</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_FLT_SEGMENTS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_FLT_SEGMENTS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 15, "IT_FLT_ITEMS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Flt_Items", com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Flt_ItemsType(), new java.lang.String[][]{}, "IT_FLT_ITEMS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_FLT_ITEMS\"><ifr:descriptor><ifr:description language=\"EN\">OTA Fligth Items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_FLT_ITEMS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_FLT_ITEMS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Y_Ota_Cid_Update_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Y_Ota_Cid_Update_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_Trn_HdrType_List get_as_listIt_Trn_Hdr() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_Trn_HdrType_List)baseTypeData().getElementValue(5);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Trn_ItemsType[] getIt_Trn_Items() {
        com.kcdata.abe.bapi.util.Yst_Bapi_Trn_ItemsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_Trn_ItemsType_List)baseTypeData().getElementValue(4);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_Trn_ItemsType();
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_ItemsType[] getIt_Flt_Items() {
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List)baseTypeData().getElementValue(15);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Flt_ItemsType();
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType[] getIt_Ins_Items() {
        com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List)baseTypeData().getElementValue(10);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_Ins_ItemsType();
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List get_as_listIt_Ser_Items() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List)baseTypeData().getElementValue(7);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List get_as_listIt_Htl_Items() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List)baseTypeData().getElementValue(12);
    }

    public MetaData metadataY_Ota_Cid_Update_Input() {
        return metadata;
    }

    public void setIt_Return(com.kcdata.abe.bapi.util.Bapiret2Type_List It_Return) {
        baseTypeData().setElementValue(9, It_Return);
    }

    public com.kcdata.abe.bapi.util.Yzseat_Info_SType_List get_as_listIt_Seatmap() {
        return (com.kcdata.abe.bapi.util.Yzseat_Info_SType_List)baseTypeData().getElementValue(8);
    }

    public void setIt_Seatmap(com.kcdata.abe.bapi.Yzseat_Info_SType[] It_Seatmap) {
        baseTypeData().setElementValue(8, new com.kcdata.abe.bapi.util.Yzseat_Info_SType_List());
        com.kcdata.abe.bapi.util.Yzseat_Info_SType_List list$ = get_as_listIt_Seatmap();
        for (int  i$ = 0; i$ < It_Seatmap.length; i$++){
         list$.addYzseat_Info_SType(It_Seatmap[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Bapiret2Type_List get_as_listIt_Return() {
        return (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(9);
    }

    public void setIt_Flt_Items(com.kcdata.abe.bapi.Yst_Ota_Flt_ItemsType[] It_Flt_Items) {
        baseTypeData().setElementValue(15, new com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List list$ = get_as_listIt_Flt_Items();
        for (int  i$ = 0; i$ < It_Flt_Items.length; i$++){
         list$.addYst_Ota_Flt_ItemsType(It_Flt_Items[ i$]);
        }
    }

    public void setIt_Flt_Items(com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List It_Flt_Items) {
        baseTypeData().setElementValue(15, It_Flt_Items);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List get_as_listIt_Guestinfo() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List)baseTypeData().getElementValue(13);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType getIm_Bapi_Req_Hdr() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType)baseTypeData().getElementValue(1);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_SegmentsType[] getIt_Flt_Segments() {
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List)baseTypeData().getElementValue(14);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Flt_SegmentsType();
    }

    public void setIm_Bapi_Req_Hdr(com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType Im_Bapi_Req_Hdr) {
        baseTypeData().setElementValue(1, Im_Bapi_Req_Hdr);
    }

    public void setIt_Veh_Items(com.kcdata.abe.bapi.Yst_Ota_Veh_ItemsType[] It_Veh_Items) {
        baseTypeData().setElementValue(3, new com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List list$ = get_as_listIt_Veh_Items();
        for (int  i$ = 0; i$ < It_Veh_Items.length; i$++){
         list$.addYst_Ota_Veh_ItemsType(It_Veh_Items[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List get_as_listIt_Veh_Items() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List)baseTypeData().getElementValue(3);
    }

    public void setIt_Trn_Items(com.kcdata.abe.bapi.Yst_Bapi_Trn_ItemsType[] It_Trn_Items) {
        baseTypeData().setElementValue(4, new com.kcdata.abe.bapi.util.Yst_Bapi_Trn_ItemsType_List());
        com.kcdata.abe.bapi.util.Yst_Bapi_Trn_ItemsType_List list$ = get_as_listIt_Trn_Items();
        for (int  i$ = 0; i$ < It_Trn_Items.length; i$++){
         list$.addYst_Bapi_Trn_ItemsType(It_Trn_Items[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_Trn_ItemsType_List get_as_listIt_Trn_Items() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_Trn_ItemsType_List)baseTypeData().getElementValue(4);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List get_as_listIt_Flt_Items() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List)baseTypeData().getElementValue(15);
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List get_as_listIt_Ins_Items() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List)baseTypeData().getElementValue(10);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List get_as_listIt_Htl_Roomstaycandidates() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List)baseTypeData().getElementValue(11);
    }

    public void setIt_Guestinfo(com.kcdata.abe.bapi.Yst_Ota_GuestinfoType[] It_Guestinfo) {
        baseTypeData().setElementValue(13, new com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List list$ = get_as_listIt_Guestinfo();
        for (int  i$ = 0; i$ < It_Guestinfo.length; i$++){
         list$.addYst_Ota_GuestinfoType(It_Guestinfo[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Trn_GeninfoType[] getIt_Trn_Geninfo() {
        com.kcdata.abe.bapi.util.Yst_Bapi_Trn_GeninfoType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_Trn_GeninfoType_List)baseTypeData().getElementValue(6);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_Trn_GeninfoType();
    }

    public com.kcdata.abe.bapi.Bapiret2Type[] getIt_Return() {
        com.kcdata.abe.bapi.util.Bapiret2Type_List i$ = (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(9);
        if ( i$ == null){return null;}
        return  i$.toArrayBapiret2Type();
    }

    public void setIt_Trn_Items(com.kcdata.abe.bapi.util.Yst_Bapi_Trn_ItemsType_List It_Trn_Items) {
        baseTypeData().setElementValue(4, It_Trn_Items);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType[] getIt_Trn_Hdr() {
        com.kcdata.abe.bapi.util.Yst_Bapi_Trn_HdrType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_Trn_HdrType_List)baseTypeData().getElementValue(5);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_Trn_HdrType();
    }

    public void setIt_Trn_Geninfo(com.kcdata.abe.bapi.util.Yst_Bapi_Trn_GeninfoType_List It_Trn_Geninfo) {
        baseTypeData().setElementValue(6, It_Trn_Geninfo);
    }

    public void setIt_Ins_Items(com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List It_Ins_Items) {
        baseTypeData().setElementValue(10, It_Ins_Items);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Ser_ItemsType[] getIt_Ser_Items() {
        com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List)baseTypeData().getElementValue(7);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Ser_ItemsType();
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType[] getIt_Htl_Items() {
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List)baseTypeData().getElementValue(12);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Htl_ItemsType();
    }

    public void setIt_Flt_Segments(com.kcdata.abe.bapi.Yst_Ota_Flt_SegmentsType[] It_Flt_Segments) {
        baseTypeData().setElementValue(14, new com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List list$ = get_as_listIt_Flt_Segments();
        for (int  i$ = 0; i$ < It_Flt_Segments.length; i$++){
         list$.addYst_Ota_Flt_SegmentsType(It_Flt_Segments[ i$]);
        }
    }

    public void setIt_Ser_Items(com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List It_Ser_Items) {
        baseTypeData().setElementValue(7, It_Ser_Items);
    }

    public void setIt_Htl_Items(com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List It_Htl_Items) {
        baseTypeData().setElementValue(12, It_Htl_Items);
    }

    public com.kcdata.abe.bapi.Yzseat_Info_SType[] getIt_Seatmap() {
        com.kcdata.abe.bapi.util.Yzseat_Info_SType_List i$ = (com.kcdata.abe.bapi.util.Yzseat_Info_SType_List)baseTypeData().getElementValue(8);
        if ( i$ == null){return null;}
        return  i$.toArrayYzseat_Info_SType();
    }

    public void setIt_Flt_Segments(com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List It_Flt_Segments) {
        baseTypeData().setElementValue(14, It_Flt_Segments);
    }

    public void setIt_Trn_Hdr(com.kcdata.abe.bapi.util.Yst_Bapi_Trn_HdrType_List It_Trn_Hdr) {
        baseTypeData().setElementValue(5, It_Trn_Hdr);
    }

    public void setCh_St_Bapi_Metadata(com.kcdata.abe.bapi.Yst_MetadataType Ch_St_Bapi_Metadata) {
        baseTypeData().setElementValue(0, Ch_St_Bapi_Metadata);
    }

    public void setIt_Return(com.kcdata.abe.bapi.Bapiret2Type[] It_Return) {
        baseTypeData().setElementValue(9, new com.kcdata.abe.bapi.util.Bapiret2Type_List());
        com.kcdata.abe.bapi.util.Bapiret2Type_List list$ = get_as_listIt_Return();
        for (int  i$ = 0; i$ < It_Return.length; i$++){
         list$.addBapiret2Type(It_Return[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType getIm_St_Appli_Info() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType)baseTypeData().getElementValue(2);
    }

    public void setIt_Seatmap(com.kcdata.abe.bapi.util.Yzseat_Info_SType_List It_Seatmap) {
        baseTypeData().setElementValue(8, It_Seatmap);
    }

    public com.kcdata.abe.bapi.Yst_Ota_GuestinfoType[] getIt_Guestinfo() {
        com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List)baseTypeData().getElementValue(13);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_GuestinfoType();
    }

    public void setIt_Trn_Geninfo(com.kcdata.abe.bapi.Yst_Bapi_Trn_GeninfoType[] It_Trn_Geninfo) {
        baseTypeData().setElementValue(6, new com.kcdata.abe.bapi.util.Yst_Bapi_Trn_GeninfoType_List());
        com.kcdata.abe.bapi.util.Yst_Bapi_Trn_GeninfoType_List list$ = get_as_listIt_Trn_Geninfo();
        for (int  i$ = 0; i$ < It_Trn_Geninfo.length; i$++){
         list$.addYst_Bapi_Trn_GeninfoType(It_Trn_Geninfo[ i$]);
        }
    }

    public void setIt_Trn_Hdr(com.kcdata.abe.bapi.Yst_Bapi_Trn_HdrType[] It_Trn_Hdr) {
        baseTypeData().setElementValue(5, new com.kcdata.abe.bapi.util.Yst_Bapi_Trn_HdrType_List());
        com.kcdata.abe.bapi.util.Yst_Bapi_Trn_HdrType_List list$ = get_as_listIt_Trn_Hdr();
        for (int  i$ = 0; i$ < It_Trn_Hdr.length; i$++){
         list$.addYst_Bapi_Trn_HdrType(It_Trn_Hdr[ i$]);
        }
    }

    public void setIt_Ins_Items(com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType[] It_Ins_Items) {
        baseTypeData().setElementValue(10, new com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List());
        com.kcdata.abe.bapi.util.Yst_Bapi_Ins_ItemsType_List list$ = get_as_listIt_Ins_Items();
        for (int  i$ = 0; i$ < It_Ins_Items.length; i$++){
         list$.addYst_Bapi_Ins_ItemsType(It_Ins_Items[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List get_as_listIt_Flt_Segments() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List)baseTypeData().getElementValue(14);
    }

    public void setIm_St_Appli_Info(com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType Im_St_Appli_Info) {
        baseTypeData().setElementValue(2, Im_St_Appli_Info);
    }

    public com.kcdata.abe.bapi.Yst_Ota_RoomstaycandidatesType[] getIt_Htl_Roomstaycandidates() {
        com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List)baseTypeData().getElementValue(11);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_RoomstaycandidatesType();
    }

    public void setIt_Htl_Roomstaycandidates(com.kcdata.abe.bapi.Yst_Ota_RoomstaycandidatesType[] It_Htl_Roomstaycandidates) {
        baseTypeData().setElementValue(11, new com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List list$ = get_as_listIt_Htl_Roomstaycandidates();
        for (int  i$ = 0; i$ < It_Htl_Roomstaycandidates.length; i$++){
         list$.addYst_Ota_RoomstaycandidatesType(It_Htl_Roomstaycandidates[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_Trn_GeninfoType_List get_as_listIt_Trn_Geninfo() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_Trn_GeninfoType_List)baseTypeData().getElementValue(6);
    }

    public void setIt_Ser_Items(com.kcdata.abe.bapi.Yst_Ota_Ser_ItemsType[] It_Ser_Items) {
        baseTypeData().setElementValue(7, new com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Ser_ItemsType_List list$ = get_as_listIt_Ser_Items();
        for (int  i$ = 0; i$ < It_Ser_Items.length; i$++){
         list$.addYst_Ota_Ser_ItemsType(It_Ser_Items[ i$]);
        }
    }

    public void setIt_Htl_Roomstaycandidates(com.kcdata.abe.bapi.util.Yst_Ota_RoomstaycandidatesType_List It_Htl_Roomstaycandidates) {
        baseTypeData().setElementValue(11, It_Htl_Roomstaycandidates);
    }

    public void setIt_Htl_Items(com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType[] It_Htl_Items) {
        baseTypeData().setElementValue(12, new com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List list$ = get_as_listIt_Htl_Items();
        for (int  i$ = 0; i$ < It_Htl_Items.length; i$++){
         list$.addYst_Ota_Htl_ItemsType(It_Htl_Items[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_MetadataType getCh_St_Bapi_Metadata() {
        return (com.kcdata.abe.bapi.Yst_MetadataType)baseTypeData().getElementValue(0);
    }

    public void setIt_Veh_Items(com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List It_Veh_Items) {
        baseTypeData().setElementValue(3, It_Veh_Items);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Veh_ItemsType[] getIt_Veh_Items() {
        com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Veh_ItemsType_List)baseTypeData().getElementValue(3);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Veh_ItemsType();
    }

    public void setIt_Guestinfo(com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List It_Guestinfo) {
        baseTypeData().setElementValue(13, It_Guestinfo);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Ota_Cid_Update_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Ota_Cid_Update_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Seatmap() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(8);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Bapi_Req_Hdr() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Trn_Items() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Flt_Items() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(15);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Trn_Geninfo() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(6);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Ins_Items() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(10);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Flt_Segments() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(14);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(9);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Trn_Hdr() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Guestinfo() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(13);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_St_Appli_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Htl_Items() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(12);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Ser_Items() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(7);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Htl_Roomstaycandidates() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(11);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCh_St_Bapi_Metadata() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Veh_Items() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
    }

}
