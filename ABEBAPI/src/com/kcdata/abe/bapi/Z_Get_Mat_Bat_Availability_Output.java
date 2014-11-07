package com.kcdata.abe.bapi;
public class Z_Get_Mat_Bat_Availability_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1322472203982L) ;

    private  Z_Get_Mat_Bat_Availability_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Z_GET_MAT_BAT_AVAILABILITY.Output", 1, 0, com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Z_GET_MAT_BAT_AVAILABILITY", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Material/S.Loc/Batch  Availability</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>ZMMM</ifr:package><ifr:akhNode /><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "IT_MAT_BAT", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Mat_Bat", com.kcdata.abe.bapi.util.Zmat_BatType_List.class, new com.kcdata.abe.bapi.Zmat_BatType(), new java.lang.String[][]{}, "IT_MAT_BAT", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_MAT_BAT\"><ifr:descriptor><ifr:description language=\"EN\">Material/S.Loc/Batch</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZMAT_BAT\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZMAT_BAT\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Z_Get_Mat_Bat_Availability_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Z_Get_Mat_Bat_Availability_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public com.kcdata.abe.bapi.Zmat_BatType[] getIt_Mat_Bat() {
        com.kcdata.abe.bapi.util.Zmat_BatType_List i$ = (com.kcdata.abe.bapi.util.Zmat_BatType_List)baseTypeData().getElementValue(0);
        if ( i$ == null){return null;}
        return  i$.toArrayZmat_BatType();
    }

    public com.kcdata.abe.bapi.util.Zmat_BatType_List get_as_listIt_Mat_Bat() {
        return (com.kcdata.abe.bapi.util.Zmat_BatType_List)baseTypeData().getElementValue(0);
    }

    public MetaData metadataZ_Get_Mat_Bat_Availability_Output() {
        return metadata;
    }

    public void setIt_Mat_Bat(com.kcdata.abe.bapi.Zmat_BatType[] It_Mat_Bat) {
        baseTypeData().setElementValue(0, new com.kcdata.abe.bapi.util.Zmat_BatType_List());
        com.kcdata.abe.bapi.util.Zmat_BatType_List list$ = get_as_listIt_Mat_Bat();
        for (int  i$ = 0; i$ < It_Mat_Bat.length; i$++){
         list$.addZmat_BatType(It_Mat_Bat[ i$]);
        }
    }

    public void setIt_Mat_Bat(com.kcdata.abe.bapi.util.Zmat_BatType_List It_Mat_Bat) {
        baseTypeData().setElementValue(0, It_Mat_Bat);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Z_Get_Mat_Bat_Availability_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Z_Get_Mat_Bat_Availability_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Mat_Bat() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
