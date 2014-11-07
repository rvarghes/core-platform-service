package com.kcdata.abe.bapi;
public class Z_Api_Order_Get_Comments_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1256262598703L) ;

    private  Z_Api_Order_Get_Comments_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Z_API_ORDER_GET_COMMENTS.Input", 3, 0, com.kcdata.abe.bapi.Z_Api_Order_Get_Comments_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Z_API_ORDER_GET_COMMENTS", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Get comments entered for a Booking</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>ZAPI</ifr:package><ifr:akhNode>HLB0009009</ifr:akhNode><ifr:released>external</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "BOOKING_NUMBER", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Booking_Number", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "10"}}, "BOOKING_NUMBER", 0, 0, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"BOOKING_NUMBER\"><ifr:descriptor /><ifr:definition><ifr:field name=\"VBAK.VBELN\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:checkTable>VBUK</ifr:checkTable><ifr:offset1>3</ifr:offset1><ifr:offset2>6</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"VBELN_VA\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength><ifr:conversionExit>ALPHA</ifr:conversionExit></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "COMMENTS_L", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Comments_L", com.kcdata.abe.bapi.util.Zapi_Comments_DtlType_List.class, new com.kcdata.abe.bapi.Zapi_Comments_DtlType(), new java.lang.String[][]{}, "COMMENTS_L", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"COMMENTS_L\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZAPI_COMMENTS_DTL\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_COMMENTS_DTL\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "COMMENTS_H", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Comments_H", com.kcdata.abe.bapi.util.Zapi_CommentsType_List.class, new com.kcdata.abe.bapi.Zapi_CommentsType(), new java.lang.String[][]{}, "COMMENTS_H", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"COMMENTS_H\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZAPI_COMMENTS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_COMMENTS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    protected  Z_Api_Order_Get_Comments_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Z_Api_Order_Get_Comments_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.util.Zapi_CommentsType_List get_as_listComments_H() {
        return (com.kcdata.abe.bapi.util.Zapi_CommentsType_List)baseTypeData().getElementValue(2);
    }

    public com.kcdata.abe.bapi.Zapi_Comments_DtlType[] getComments_L() {
        com.kcdata.abe.bapi.util.Zapi_Comments_DtlType_List i$ = (com.kcdata.abe.bapi.util.Zapi_Comments_DtlType_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_Comments_DtlType();
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

    public void setBooking_Number(java.lang.String Booking_Number) {
        baseTypeData().setElementValue(0, Booking_Number);
    }

    public void setComments_L(com.kcdata.abe.bapi.util.Zapi_Comments_DtlType_List Comments_L) {
        baseTypeData().setElementValue(1, Comments_L);
    }

    public MetaData metadataZ_Api_Order_Get_Comments_Input() {
        return metadata;
    }

    public java.lang.String getBooking_Number() {
        return (java.lang.String)baseTypeData().getElementValueAsString(0);
    }

    public void setComments_H(com.kcdata.abe.bapi.util.Zapi_CommentsType_List Comments_H) {
        baseTypeData().setElementValue(2, Comments_H);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Z_Api_Order_Get_Comments_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Z_Api_Order_Get_Comments_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getComments_L() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getComments_H() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getBooking_Number() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
