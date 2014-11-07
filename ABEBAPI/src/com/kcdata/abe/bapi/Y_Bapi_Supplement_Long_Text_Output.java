package com.kcdata.abe.bapi;
public class Y_Bapi_Supplement_Long_Text_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1256083563765L) ;

    private  Y_Bapi_Supplement_Long_Text_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_BAPI_SUPPLEMENT_LONG_TEXT.Output", 2, 0, com.kcdata.abe.bapi.Y_Bapi_Supplement_Long_Text_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_BAPI_SUPPLEMENT_LONG_TEXT", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Get Supplement long text</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "ES_RETURN", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:BAPIRETURN", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Es_Return", com.kcdata.abe.bapi.BapireturnType.class, new com.kcdata.abe.bapi.BapireturnType(), new java.lang.String[][]{}, "ES_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"ES_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRETURN\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRETURN\" /></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IT_MATERIAL_TEXT", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Material_Text", com.kcdata.abe.bapi.util.TlineType_List.class, new com.kcdata.abe.bapi.TlineType(), new java.lang.String[][]{}, "IT_MATERIAL_TEXT", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_MATERIAL_TEXT\"><ifr:descriptor><ifr:description language=\"EN\">SAPscript: Text Lines</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"TLINE\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=TLINE\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Y_Bapi_Supplement_Long_Text_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Y_Bapi_Supplement_Long_Text_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public void setEs_Return(com.kcdata.abe.bapi.BapireturnType Es_Return) {
        baseTypeData().setElementValue(0, Es_Return);
    }

    public void setIt_Material_Text(com.kcdata.abe.bapi.TlineType[] It_Material_Text) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.TlineType_List());
        com.kcdata.abe.bapi.util.TlineType_List list$ = get_as_listIt_Material_Text();
        for (int  i$ = 0; i$ < It_Material_Text.length; i$++){
         list$.addTlineType(It_Material_Text[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.TlineType_List get_as_listIt_Material_Text() {
        return (com.kcdata.abe.bapi.util.TlineType_List)baseTypeData().getElementValue(1);
    }

    public com.kcdata.abe.bapi.TlineType[] getIt_Material_Text() {
        com.kcdata.abe.bapi.util.TlineType_List i$ = (com.kcdata.abe.bapi.util.TlineType_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayTlineType();
    }

    public com.kcdata.abe.bapi.BapireturnType getEs_Return() {
        return (com.kcdata.abe.bapi.BapireturnType)baseTypeData().getElementValue(0);
    }

    public MetaData metadataY_Bapi_Supplement_Long_Text_Output() {
        return metadata;
    }

    public void setIt_Material_Text(com.kcdata.abe.bapi.util.TlineType_List It_Material_Text) {
        baseTypeData().setElementValue(1, It_Material_Text);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Bapi_Supplement_Long_Text_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Bapi_Supplement_Long_Text_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Material_Text() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getEs_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
