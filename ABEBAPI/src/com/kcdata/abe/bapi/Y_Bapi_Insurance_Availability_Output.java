package com.kcdata.abe.bapi;
public class Y_Bapi_Insurance_Availability_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1341668215031L) ;

    private  Y_Bapi_Insurance_Availability_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_BAPI_INSURANCE_AVAILABILITY.Output", 8, 0, com.kcdata.abe.bapi.Y_Bapi_Insurance_Availability_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_BAPI_INSURANCE_AVAILABILITY", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Insurance Availability</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "CH_ST_BAPI_METADATA", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_METADATA", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ch_St_Bapi_Metadata", com.kcdata.abe.bapi.Yst_MetadataType.class, new com.kcdata.abe.bapi.Yst_MetadataType(), new java.lang.String[][]{}, "CH_ST_BAPI_METADATA", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER | com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"CH_ST_BAPI_METADATA\"><ifr:descriptor><ifr:description language=\"EN\">Matadata for BAPI Request Interface</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_METADATA\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_METADATA\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>changing</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IT_RETURN", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Return", com.kcdata.abe.bapi.util.Bapiret2Type_List.class, new com.kcdata.abe.bapi.Bapiret2Type(), new java.lang.String[][]{}, "IT_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRET2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRET2\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IT_MAT_LONG_TEXT", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Mat_Long_Text", com.kcdata.abe.bapi.util.Yst_Bapi_Long_TextType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_Long_TextType(), new java.lang.String[][]{}, "IT_MAT_LONG_TEXT", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_MAT_LONG_TEXT\"><ifr:descriptor><ifr:description language=\"EN\">BAPI long text</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_LONG_TEXT\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_LONG_TEXT\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "IT_INS_AVAIL", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Ins_Avail", com.kcdata.abe.bapi.util.Yst_Bapi_Ins_AvailabilityType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType(), new java.lang.String[][]{}, "IT_INS_AVAIL", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_INS_AVAIL\"><ifr:descriptor><ifr:description language=\"EN\">BAPI AVOK Insurance Availability</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_INS_AVAILABILITY\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_INS_AVAILABILITY\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "IT_HTL_ITEMS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Htl_Items", com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType(), new java.lang.String[][]{}, "IT_HTL_ITEMS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_HTL_ITEMS\"><ifr:descriptor><ifr:description language=\"EN\">OTA Hotel items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_HTL_ITEMS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_HTL_ITEMS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 5, "IT_GUESTINFO", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Guestinfo", com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List.class, new com.kcdata.abe.bapi.Yst_Ota_GuestinfoType(), new java.lang.String[][]{}, "IT_GUESTINFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_GUESTINFO\"><ifr:descriptor><ifr:description language=\"EN\">OTA Passenger Information</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_GUESTINFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_GUESTINFO\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 6, "IT_FLT_SEGMENTS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Flt_Segments", com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Flt_SegmentsType(), new java.lang.String[][]{}, "IT_FLT_SEGMENTS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_FLT_SEGMENTS\"><ifr:descriptor><ifr:description language=\"EN\">OTA Flight Segments</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_FLT_SEGMENTS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_FLT_SEGMENTS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 7, "IT_FLT_ITEMS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Flt_Items", com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Flt_ItemsType(), new java.lang.String[][]{}, "IT_FLT_ITEMS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_FLT_ITEMS\"><ifr:descriptor><ifr:description language=\"EN\">OTA Fligth Items</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_FLT_ITEMS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_FLT_ITEMS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Y_Bapi_Insurance_Availability_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Y_Bapi_Insurance_Availability_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public void setIt_Ins_Avail(com.kcdata.abe.bapi.util.Yst_Bapi_Ins_AvailabilityType_List It_Ins_Avail) {
        baseTypeData().setElementValue(3, It_Ins_Avail);
    }

    public void setIt_Guestinfo(com.kcdata.abe.bapi.Yst_Ota_GuestinfoType[] It_Guestinfo) {
        baseTypeData().setElementValue(5, new com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List list$ = get_as_listIt_Guestinfo();
        for (int  i$ = 0; i$ < It_Guestinfo.length; i$++){
         list$.addYst_Ota_GuestinfoType(It_Guestinfo[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_ItemsType[] getIt_Flt_Items() {
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List)baseTypeData().getElementValue(7);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Flt_ItemsType();
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List get_as_listIt_Htl_Items() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List)baseTypeData().getElementValue(4);
    }

    public com.kcdata.abe.bapi.Bapiret2Type[] getIt_Return() {
        com.kcdata.abe.bapi.util.Bapiret2Type_List i$ = (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayBapiret2Type();
    }

    public void setIt_Return(com.kcdata.abe.bapi.util.Bapiret2Type_List It_Return) {
        baseTypeData().setElementValue(1, It_Return);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType[] getIt_Htl_Items() {
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List)baseTypeData().getElementValue(4);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Htl_ItemsType();
    }

    public com.kcdata.abe.bapi.util.Bapiret2Type_List get_as_listIt_Return() {
        return (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(1);
    }

    public void setIt_Flt_Items(com.kcdata.abe.bapi.Yst_Ota_Flt_ItemsType[] It_Flt_Items) {
        baseTypeData().setElementValue(7, new com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List list$ = get_as_listIt_Flt_Items();
        for (int  i$ = 0; i$ < It_Flt_Items.length; i$++){
         list$.addYst_Ota_Flt_ItemsType(It_Flt_Items[ i$]);
        }
    }

    public void setIt_Flt_Segments(com.kcdata.abe.bapi.Yst_Ota_Flt_SegmentsType[] It_Flt_Segments) {
        baseTypeData().setElementValue(6, new com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List list$ = get_as_listIt_Flt_Segments();
        for (int  i$ = 0; i$ < It_Flt_Segments.length; i$++){
         list$.addYst_Ota_Flt_SegmentsType(It_Flt_Segments[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_Long_TextType_List get_as_listIt_Mat_Long_Text() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_Long_TextType_List)baseTypeData().getElementValue(2);
    }

    public void setIt_Flt_Items(com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List It_Flt_Items) {
        baseTypeData().setElementValue(7, It_Flt_Items);
    }

    public void setIt_Htl_Items(com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List It_Htl_Items) {
        baseTypeData().setElementValue(4, It_Htl_Items);
    }

    public void setIt_Flt_Segments(com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List It_Flt_Segments) {
        baseTypeData().setElementValue(6, It_Flt_Segments);
    }

    public void setCh_St_Bapi_Metadata(com.kcdata.abe.bapi.Yst_MetadataType Ch_St_Bapi_Metadata) {
        baseTypeData().setElementValue(0, Ch_St_Bapi_Metadata);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List get_as_listIt_Guestinfo() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List)baseTypeData().getElementValue(5);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Long_TextType[] getIt_Mat_Long_Text() {
        com.kcdata.abe.bapi.util.Yst_Bapi_Long_TextType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_Long_TextType_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_Long_TextType();
    }

    public void setIt_Return(com.kcdata.abe.bapi.Bapiret2Type[] It_Return) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.Bapiret2Type_List());
        com.kcdata.abe.bapi.util.Bapiret2Type_List list$ = get_as_listIt_Return();
        for (int  i$ = 0; i$ < It_Return.length; i$++){
         list$.addBapiret2Type(It_Return[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_SegmentsType[] getIt_Flt_Segments() {
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List)baseTypeData().getElementValue(6);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Flt_SegmentsType();
    }

    public MetaData metadataY_Bapi_Insurance_Availability_Output() {
        return metadata;
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_Ins_AvailabilityType_List get_as_listIt_Ins_Avail() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_Ins_AvailabilityType_List)baseTypeData().getElementValue(3);
    }

    public void setIt_Ins_Avail(com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType[] It_Ins_Avail) {
        baseTypeData().setElementValue(3, new com.kcdata.abe.bapi.util.Yst_Bapi_Ins_AvailabilityType_List());
        com.kcdata.abe.bapi.util.Yst_Bapi_Ins_AvailabilityType_List list$ = get_as_listIt_Ins_Avail();
        for (int  i$ = 0; i$ < It_Ins_Avail.length; i$++){
         list$.addYst_Bapi_Ins_AvailabilityType(It_Ins_Avail[ i$]);
        }
    }

    public void setIt_Mat_Long_Text(com.kcdata.abe.bapi.util.Yst_Bapi_Long_TextType_List It_Mat_Long_Text) {
        baseTypeData().setElementValue(2, It_Mat_Long_Text);
    }

    public void setIt_Mat_Long_Text(com.kcdata.abe.bapi.Yst_Bapi_Long_TextType[] It_Mat_Long_Text) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.Yst_Bapi_Long_TextType_List());
        com.kcdata.abe.bapi.util.Yst_Bapi_Long_TextType_List list$ = get_as_listIt_Mat_Long_Text();
        for (int  i$ = 0; i$ < It_Mat_Long_Text.length; i$++){
         list$.addYst_Bapi_Long_TextType(It_Mat_Long_Text[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Ota_GuestinfoType[] getIt_Guestinfo() {
        com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List)baseTypeData().getElementValue(5);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_GuestinfoType();
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List get_as_listIt_Flt_Segments() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Flt_SegmentsType_List)baseTypeData().getElementValue(6);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Ins_AvailabilityType[] getIt_Ins_Avail() {
        com.kcdata.abe.bapi.util.Yst_Bapi_Ins_AvailabilityType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_Ins_AvailabilityType_List)baseTypeData().getElementValue(3);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_Ins_AvailabilityType();
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List get_as_listIt_Flt_Items() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Flt_ItemsType_List)baseTypeData().getElementValue(7);
    }

    public void setIt_Htl_Items(com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType[] It_Htl_Items) {
        baseTypeData().setElementValue(4, new com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Htl_ItemsType_List list$ = get_as_listIt_Htl_Items();
        for (int  i$ = 0; i$ < It_Htl_Items.length; i$++){
         list$.addYst_Ota_Htl_ItemsType(It_Htl_Items[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_MetadataType getCh_St_Bapi_Metadata() {
        return (com.kcdata.abe.bapi.Yst_MetadataType)baseTypeData().getElementValue(0);
    }

    public void setIt_Guestinfo(com.kcdata.abe.bapi.util.Yst_Ota_GuestinfoType_List It_Guestinfo) {
        baseTypeData().setElementValue(5, It_Guestinfo);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Bapi_Insurance_Availability_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Bapi_Insurance_Availability_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Guestinfo() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Htl_Items() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Mat_Long_Text() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Flt_Items() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(7);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Ins_Avail() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Flt_Segments() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(6);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCh_St_Bapi_Metadata() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
