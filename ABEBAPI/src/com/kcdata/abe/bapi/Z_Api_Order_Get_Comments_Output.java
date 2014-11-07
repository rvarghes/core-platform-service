package com.kcdata.abe.bapi;
public class Z_Api_Order_Get_Comments_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1256262598703L) ;

    private  Z_Api_Order_Get_Comments_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Z_API_ORDER_GET_COMMENTS.Output", 3, 0, com.kcdata.abe.bapi.Z_Api_Order_Get_Comments_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Z_API_ORDER_GET_COMMENTS", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Get comments entered for a Booking</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>ZAPI</ifr:package><ifr:akhNode>HLB0009009</ifr:akhNode><ifr:released>external</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "RETURN", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:BAPIRETURN", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Return", com.kcdata.abe.bapi.BapireturnType.class, new com.kcdata.abe.bapi.BapireturnType(), new java.lang.String[][]{}, "RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"RETURN\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"BAPIRETURN\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRETURN\" /></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "COMMENTS_L", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Comments_L", com.kcdata.abe.bapi.util.Zapi_Comments_DtlType_List.class, new com.kcdata.abe.bapi.Zapi_Comments_DtlType(), new java.lang.String[][]{}, "COMMENTS_L", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"COMMENTS_L\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZAPI_COMMENTS_DTL\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_COMMENTS_DTL\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "COMMENTS_H", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Comments_H", com.kcdata.abe.bapi.util.Zapi_CommentsType_List.class, new com.kcdata.abe.bapi.Zapi_CommentsType(), new java.lang.String[][]{}, "COMMENTS_H", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"COMMENTS_H\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZAPI_COMMENTS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_COMMENTS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Z_Api_Order_Get_Comments_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Z_Api_Order_Get_Comments_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public com.kcdata.abe.bapi.util.Zapi_CommentsType_List get_as_listComments_H() {
        return (com.kcdata.abe.bapi.util.Zapi_CommentsType_List)baseTypeData().getElementValue(2);
    }

    public com.kcdata.abe.bapi.Zapi_Comments_DtlType[] getComments_L() {
        com.kcdata.abe.bapi.util.Zapi_Comments_DtlType_List i$ = (com.kcdata.abe.bapi.util.Zapi_Comments_DtlType_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_Comments_DtlType();
    }

    public void setReturn(com.kcdata.abe.bapi.BapireturnType Return) {
        baseTypeData().setElementValue(0, Return);
    }

    public com.kcdata.abe.bapi.BapireturnType getReturn() {
        return (com.kcdata.abe.bapi.BapireturnType)baseTypeData().getElementValue(0);
    }

    public MetaData metadataZ_Api_Order_Get_Comments_Output() {
        return metadata;
    }

    public void setComments_H(com.kcdata.abe.bapi.Zapi_CommentsType[] Comments_H) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.Zapi_CommentsType_List());
        com.kcdata.abe.bapi.util.Zapi_CommentsType_List list$ = get_as_listComments_H();
        for (int  i$ = 0; i$ < Comments_H.length; i$++){
         list$.addZapi_CommentsType(Comments_H[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Zapi_CommentsType[] getComments_H() {
        com.kcdata.abe.bapi.util.Zapi_CommentsType_List i$ = (com.kcdata.abe.bapi.util.Zapi_CommentsType_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_CommentsType();
    }

    public com.kcdata.abe.bapi.util.Zapi_Comments_DtlType_List get_as_listComments_L() {
        return (com.kcdata.abe.bapi.util.Zapi_Comments_DtlType_List)baseTypeData().getElementValue(1);
    }

    public void setComments_L(com.kcdata.abe.bapi.Zapi_Comments_DtlType[] Comments_L) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.Zapi_Comments_DtlType_List());
        com.kcdata.abe.bapi.util.Zapi_Comments_DtlType_List list$ = get_as_listComments_L();
        for (int  i$ = 0; i$ < Comments_L.length; i$++){
         list$.addZapi_Comments_DtlType(Comments_L[ i$]);
        }
    }

    public void setComments_L(com.kcdata.abe.bapi.util.Zapi_Comments_DtlType_List Comments_L) {
        baseTypeData().setElementValue(1, Comments_L);
    }

    public void setComments_H(com.kcdata.abe.bapi.util.Zapi_CommentsType_List Comments_H) {
        baseTypeData().setElementValue(2, Comments_H);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Z_Api_Order_Get_Comments_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Z_Api_Order_Get_Comments_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getComments_L() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getReturn() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getComments_H() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
    }

}
