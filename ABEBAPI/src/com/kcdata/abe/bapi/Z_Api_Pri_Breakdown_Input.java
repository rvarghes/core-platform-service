package com.kcdata.abe.bapi;
public class Z_Api_Pri_Breakdown_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1291331393156L) ;

    private  Z_Api_Pri_Breakdown_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Z_API_PRI_BREAKDOWN.Input", 5, 0, com.kcdata.abe.bapi.Z_Api_Pri_Breakdown_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Z_API_PRI_BREAKDOWN", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Display Charges</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>ZAPI</ifr:package><ifr:akhNode>HLB0009009</ifr:akhNode><ifr:released>external</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "BOOKINGNUMBER", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Bookingnumber", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "10"}}, "BOOKINGNUMBER", 0, 0, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"BOOKINGNUMBER\"><ifr:descriptor><ifr:description language=\"EN\">Booking Number</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"VBAK.VBELN\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:checkTable>VBUK</ifr:checkTable><ifr:offset1>3</ifr:offset1><ifr:offset2>6</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"VBELN_VA\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength><ifr:conversionExit>ALPHA</ifr:conversionExit></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "MATERIAL_PRICE", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Material_Price", com.kcdata.abe.bapi.util.Zapi_Matl_PriceType_List.class, new com.kcdata.abe.bapi.Zapi_Matl_PriceType(), new java.lang.String[][]{}, "MATERIAL_PRICE", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"MATERIAL_PRICE\"><ifr:descriptor><ifr:description language=\"EN\">Commission Details</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_MATL_PRICE\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_MATL_PRICE\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "HEADERPRICES", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Headerprices", com.kcdata.abe.bapi.util.Zapi_Pax_InfoType_List.class, new com.kcdata.abe.bapi.Zapi_Pax_InfoType(), new java.lang.String[][]{}, "HEADERPRICES", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"HEADERPRICES\"><ifr:descriptor><ifr:description language=\"EN\">Header Price Information</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_PAX_INFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_PAX_INFO\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "DETAILPRICES", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Detailprices", com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailType_List.class, new com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType(), new java.lang.String[][]{}, "DETAILPRICES", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"DETAILPRICES\"><ifr:descriptor><ifr:description language=\"EN\">Detail Price Information</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_PAX_INFO_DETAIL\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_PAX_INFO_DETAIL\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "COMMISSIONDTLS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Commissiondtls", com.kcdata.abe.bapi.util.Zapi_Commission_DtlsType_List.class, new com.kcdata.abe.bapi.Zapi_Commission_DtlsType(), new java.lang.String[][]{}, "COMMISSIONDTLS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"COMMISSIONDTLS\"><ifr:descriptor><ifr:description language=\"EN\">Commission Details</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_COMMISSION_DTLS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_COMMISSION_DTLS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    protected  Z_Api_Pri_Breakdown_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Z_Api_Pri_Breakdown_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.util.Zapi_Pax_InfoType_List get_as_listHeaderprices() {
        return (com.kcdata.abe.bapi.util.Zapi_Pax_InfoType_List)baseTypeData().getElementValue(2);
    }

    public com.kcdata.abe.bapi.Zapi_Pax_InfoType[] getHeaderprices() {
        com.kcdata.abe.bapi.util.Zapi_Pax_InfoType_List i$ = (com.kcdata.abe.bapi.util.Zapi_Pax_InfoType_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_Pax_InfoType();
    }

    public void setCommissiondtls(com.kcdata.abe.bapi.util.Zapi_Commission_DtlsType_List Commissiondtls) {
        baseTypeData().setElementValue(4, Commissiondtls);
    }

    public void setCommissiondtls(com.kcdata.abe.bapi.Zapi_Commission_DtlsType[] Commissiondtls) {
        baseTypeData().setElementValue(4, new com.kcdata.abe.bapi.util.Zapi_Commission_DtlsType_List());
        com.kcdata.abe.bapi.util.Zapi_Commission_DtlsType_List list$ = get_as_listCommissiondtls();
        for (int  i$ = 0; i$ < Commissiondtls.length; i$++){
         list$.addZapi_Commission_DtlsType(Commissiondtls[ i$]);
        }
    }

    public void setHeaderprices(com.kcdata.abe.bapi.util.Zapi_Pax_InfoType_List Headerprices) {
        baseTypeData().setElementValue(2, Headerprices);
    }

    public MetaData metadataZ_Api_Pri_Breakdown_Input() {
        return metadata;
    }

    public com.kcdata.abe.bapi.Zapi_Commission_DtlsType[] getCommissiondtls() {
        com.kcdata.abe.bapi.util.Zapi_Commission_DtlsType_List i$ = (com.kcdata.abe.bapi.util.Zapi_Commission_DtlsType_List)baseTypeData().getElementValue(4);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_Commission_DtlsType();
    }

    public java.lang.String getBookingnumber() {
        return (java.lang.String)baseTypeData().getElementValueAsString(0);
    }

    public com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType[] getDetailprices() {
        com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailType_List i$ = (com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailType_List)baseTypeData().getElementValue(3);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_Pax_Info_DetailType();
    }

    public void setMaterial_Price(com.kcdata.abe.bapi.Zapi_Matl_PriceType[] Material_Price) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.Zapi_Matl_PriceType_List());
        com.kcdata.abe.bapi.util.Zapi_Matl_PriceType_List list$ = get_as_listMaterial_Price();
        for (int  i$ = 0; i$ < Material_Price.length; i$++){
         list$.addZapi_Matl_PriceType(Material_Price[ i$]);
        }
    }

    public void setDetailprices(com.kcdata.abe.bapi.Zapi_Pax_Info_DetailType[] Detailprices) {
        baseTypeData().setElementValue(3, new com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailType_List());
        com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailType_List list$ = get_as_listDetailprices();
        for (int  i$ = 0; i$ < Detailprices.length; i$++){
         list$.addZapi_Pax_Info_DetailType(Detailprices[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Zapi_Matl_PriceType_List get_as_listMaterial_Price() {
        return (com.kcdata.abe.bapi.util.Zapi_Matl_PriceType_List)baseTypeData().getElementValue(1);
    }

    public void setMaterial_Price(com.kcdata.abe.bapi.util.Zapi_Matl_PriceType_List Material_Price) {
        baseTypeData().setElementValue(1, Material_Price);
    }

    public com.kcdata.abe.bapi.Zapi_Matl_PriceType[] getMaterial_Price() {
        com.kcdata.abe.bapi.util.Zapi_Matl_PriceType_List i$ = (com.kcdata.abe.bapi.util.Zapi_Matl_PriceType_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_Matl_PriceType();
    }

    public void setDetailprices(com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailType_List Detailprices) {
        baseTypeData().setElementValue(3, Detailprices);
    }

    public com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailType_List get_as_listDetailprices() {
        return (com.kcdata.abe.bapi.util.Zapi_Pax_Info_DetailType_List)baseTypeData().getElementValue(3);
    }

    public com.kcdata.abe.bapi.util.Zapi_Commission_DtlsType_List get_as_listCommissiondtls() {
        return (com.kcdata.abe.bapi.util.Zapi_Commission_DtlsType_List)baseTypeData().getElementValue(4);
    }

    public void setHeaderprices(com.kcdata.abe.bapi.Zapi_Pax_InfoType[] Headerprices) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.Zapi_Pax_InfoType_List());
        com.kcdata.abe.bapi.util.Zapi_Pax_InfoType_List list$ = get_as_listHeaderprices();
        for (int  i$ = 0; i$ < Headerprices.length; i$++){
         list$.addZapi_Pax_InfoType(Headerprices[ i$]);
        }
    }

    public void setBookingnumber(java.lang.String Bookingnumber) {
        baseTypeData().setElementValue(0, Bookingnumber);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Z_Api_Pri_Breakdown_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Z_Api_Pri_Breakdown_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getHeaderprices() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getMaterial_Price() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCommissiondtls() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getDetailprices() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getBookingnumber() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
