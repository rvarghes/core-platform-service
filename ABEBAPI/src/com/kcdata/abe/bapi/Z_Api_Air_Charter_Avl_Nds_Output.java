package com.kcdata.abe.bapi;
public class Z_Api_Air_Charter_Avl_Nds_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1240775429218L) ;

    private  Z_Api_Air_Charter_Avl_Nds_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Z_API_AIR_CHARTER_AVL_NDS.Output", 2, 0, com.kcdata.abe.bapi.Z_Api_Air_Charter_Avl_Nds_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Z_API_AIR_CHARTER_AVL_NDS", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">NDS - Charter air availability</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>ZAPI</ifr:package><ifr:akhNode>HLB0009009</ifr:akhNode><ifr:released>external</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "RETURN", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:BAPIRETURN", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Return", com.kcdata.abe.bapi.BapireturnType.class, new com.kcdata.abe.bapi.BapireturnType(), new java.lang.String[][]{}, "RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"RETURN\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"BAPIRETURN\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRETURN\" /></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "CHARTER_DATA", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Charter_Data", com.kcdata.abe.bapi.util.Zachr_Avl_Nds_OutType_List.class, new com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType(), new java.lang.String[][]{}, "CHARTER_DATA", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"CHARTER_DATA\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZACHR_AVL_NDS_OUT\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZACHR_AVL_NDS_OUT\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Z_Api_Air_Charter_Avl_Nds_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Z_Api_Air_Charter_Avl_Nds_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public void setReturn(com.kcdata.abe.bapi.BapireturnType Return) {
        baseTypeData().setElementValue(0, Return);
    }

    public com.kcdata.abe.bapi.BapireturnType getReturn() {
        return (com.kcdata.abe.bapi.BapireturnType)baseTypeData().getElementValue(0);
    }

    public MetaData metadataZ_Api_Air_Charter_Avl_Nds_Output() {
        return metadata;
    }

    public com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType[] getCharter_Data() {
        com.kcdata.abe.bapi.util.Zachr_Avl_Nds_OutType_List i$ = (com.kcdata.abe.bapi.util.Zachr_Avl_Nds_OutType_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayZachr_Avl_Nds_OutType();
    }

    public void setCharter_Data(com.kcdata.abe.bapi.util.Zachr_Avl_Nds_OutType_List Charter_Data) {
        baseTypeData().setElementValue(1, Charter_Data);
    }

    public com.kcdata.abe.bapi.util.Zachr_Avl_Nds_OutType_List get_as_listCharter_Data() {
        return (com.kcdata.abe.bapi.util.Zachr_Avl_Nds_OutType_List)baseTypeData().getElementValue(1);
    }

    public void setCharter_Data(com.kcdata.abe.bapi.Zachr_Avl_Nds_OutType[] Charter_Data) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.Zachr_Avl_Nds_OutType_List());
        com.kcdata.abe.bapi.util.Zachr_Avl_Nds_OutType_List list$ = get_as_listCharter_Data();
        for (int  i$ = 0; i$ < Charter_Data.length; i$++){
         list$.addZachr_Avl_Nds_OutType(Charter_Data[ i$]);
        }
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Z_Api_Air_Charter_Avl_Nds_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Z_Api_Air_Charter_Avl_Nds_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getReturn() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCharter_Data() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
    }

}
