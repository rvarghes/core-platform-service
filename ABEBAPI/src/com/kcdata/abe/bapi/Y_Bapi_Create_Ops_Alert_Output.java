package com.kcdata.abe.bapi;
public class Y_Bapi_Create_Ops_Alert_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1254952178828L) ;

    private  Y_Bapi_Create_Ops_Alert_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_BAPI_CREATE_OPS_ALERT.Output", 2, 0, com.kcdata.abe.bapi.Y_Bapi_Create_Ops_Alert_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_BAPI_CREATE_OPS_ALERT", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Function Module to create OPS ALERTS</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "EX_IT_RETURN", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:BAPIRET2", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ex_It_Return", com.kcdata.abe.bapi.Bapiret2Type.class, new com.kcdata.abe.bapi.Bapiret2Type(), new java.lang.String[][]{}, "EX_IT_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"EX_IT_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRET2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRET2\" /></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IT_PAX_ASSIGN", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Pax_Assign", com.kcdata.abe.bapi.util.Zapi_ZpaxrecapType_List.class, new com.kcdata.abe.bapi.Zapi_ZpaxrecapType(), new java.lang.String[][]{}, "IT_PAX_ASSIGN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_PAX_ASSIGN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_ZPAXRECAP\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_ZPAXRECAP\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    protected  Y_Bapi_Create_Ops_Alert_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Y_Bapi_Create_Ops_Alert_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void setIt_Pax_Assign(com.kcdata.abe.bapi.Zapi_ZpaxrecapType[] It_Pax_Assign) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.Zapi_ZpaxrecapType_List());
        com.kcdata.abe.bapi.util.Zapi_ZpaxrecapType_List list$ = get_as_listIt_Pax_Assign();
        for (int  i$ = 0; i$ < It_Pax_Assign.length; i$++){
         list$.addZapi_ZpaxrecapType(It_Pax_Assign[ i$]);
        }
    }

    public void setEx_It_Return(com.kcdata.abe.bapi.Bapiret2Type Ex_It_Return) {
        baseTypeData().setElementValue(0, Ex_It_Return);
    }

    public MetaData metadataY_Bapi_Create_Ops_Alert_Output() {
        return metadata;
    }

    public com.kcdata.abe.bapi.Zapi_ZpaxrecapType[] getIt_Pax_Assign() {
        com.kcdata.abe.bapi.util.Zapi_ZpaxrecapType_List i$ = (com.kcdata.abe.bapi.util.Zapi_ZpaxrecapType_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_ZpaxrecapType();
    }

    public void setIt_Pax_Assign(com.kcdata.abe.bapi.util.Zapi_ZpaxrecapType_List It_Pax_Assign) {
        baseTypeData().setElementValue(1, It_Pax_Assign);
    }

    public com.kcdata.abe.bapi.util.Zapi_ZpaxrecapType_List get_as_listIt_Pax_Assign() {
        return (com.kcdata.abe.bapi.util.Zapi_ZpaxrecapType_List)baseTypeData().getElementValue(1);
    }

    public com.kcdata.abe.bapi.Bapiret2Type getEx_It_Return() {
        return (com.kcdata.abe.bapi.Bapiret2Type)baseTypeData().getElementValue(0);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Bapi_Create_Ops_Alert_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Bapi_Create_Ops_Alert_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Pax_Assign() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getEx_It_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
