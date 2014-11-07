package com.kcdata.abe.bapi;
public class Z_Get_City_Pair_For_Charter_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1260552658328L) ;

    private  Z_Get_City_Pair_For_Charter_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Z_GET_CITY_PAIR_FOR_CHARTER.Input", 1, 0, com.kcdata.abe.bapi.Z_Get_City_Pair_For_Charter_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Z_GET_CITY_PAIR_FOR_CHARTER", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Get City Pair for Charter</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>ZMMM</ifr:package><ifr:akhNode /><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "IT_CHRTR_OUT", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Chrtr_Out", com.kcdata.abe.bapi.util.Zcharter_CityType_List.class, new com.kcdata.abe.bapi.Zcharter_CityType(), new java.lang.String[][]{}, "IT_CHRTR_OUT", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_CHRTR_OUT\"><ifr:descriptor><ifr:description language=\"EN\">Get City Pair for Charter material</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZCHARTER_CITY\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZCHARTER_CITY\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Z_Get_City_Pair_For_Charter_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Z_Get_City_Pair_For_Charter_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public void setIt_Chrtr_Out(com.kcdata.abe.bapi.util.Zcharter_CityType_List It_Chrtr_Out) {
        baseTypeData().setElementValue(0, It_Chrtr_Out);
    }

    public com.kcdata.abe.bapi.util.Zcharter_CityType_List get_as_listIt_Chrtr_Out() {
        return (com.kcdata.abe.bapi.util.Zcharter_CityType_List)baseTypeData().getElementValue(0);
    }

    public MetaData metadataZ_Get_City_Pair_For_Charter_Input() {
        return metadata;
    }

    public com.kcdata.abe.bapi.Zcharter_CityType[] getIt_Chrtr_Out() {
        com.kcdata.abe.bapi.util.Zcharter_CityType_List i$ = (com.kcdata.abe.bapi.util.Zcharter_CityType_List)baseTypeData().getElementValue(0);
        if ( i$ == null){return null;}
        return  i$.toArrayZcharter_CityType();
    }

    public void setIt_Chrtr_Out(com.kcdata.abe.bapi.Zcharter_CityType[] It_Chrtr_Out) {
        baseTypeData().setElementValue(0, new com.kcdata.abe.bapi.util.Zcharter_CityType_List());
        com.kcdata.abe.bapi.util.Zcharter_CityType_List list$ = get_as_listIt_Chrtr_Out();
        for (int  i$ = 0; i$ < It_Chrtr_Out.length; i$++){
         list$.addZcharter_CityType(It_Chrtr_Out[ i$]);
        }
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Z_Get_City_Pair_For_Charter_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Z_Get_City_Pair_For_Charter_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Chrtr_Out() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
