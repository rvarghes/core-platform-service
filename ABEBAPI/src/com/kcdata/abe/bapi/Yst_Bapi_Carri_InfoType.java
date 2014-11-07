package com.kcdata.abe.bapi;
public class Yst_Bapi_Carri_InfoType extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1250104867312L) ;

    private  Yst_Bapi_Carri_InfoType.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.XSDL_COMPLEX_TYPE, "urn:sap-com:document:sap:rfc:functions", "YST_BAPI_CARRI_INFO", 2, 0, com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "YST_BAPI_CARRI_INFO", 52, 104, -1, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_CARRI_INFO\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Refined Flight Search for BAPI</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>52</ifr:internalLength1><ifr:internalLength2>104</ifr:internalLength2></ifr:definition></ifr:container></s0:type>");
        descriptorSetElementProperties(descriptor, 0, "CARRIER", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Carrier", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "2"}}, "CARRIER", 0, 0, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CARRIER\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Airline Code 2 Digits</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>0</ifr:offset1><ifr:offset2>0</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZALCODE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        descriptorSetElementProperties(descriptor, 1, "CARRIER_NAME", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Carrier_Name", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "50"}}, "CARRIER_NAME", 2, 4, -1, 50, 100, -1, com.sap.mw.jco.JCO.TYPE_CHAR, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:field name=\"CARRIER_NAME\" category=\"simple\"><ifr:descriptor><ifr:description language=\"EN\">Airline Name</ifr:description></ifr:descriptor><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>2</ifr:offset1><ifr:offset2>4</ifr:offset2></ifr:properties><ifr:definition><ifr:scalarType name=\"ZCNAM\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>true</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>50</ifr:length><ifr:internalLength1>50</ifr:internalLength1><ifr:internalLength2>100</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>50</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition></ifr:field>");
        staticDescriptor = descriptor;
    }
    protected  Yst_Bapi_Carri_InfoType (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Yst_Bapi_Carri_InfoType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public java.lang.String getCarrier() {
        return (java.lang.String)baseTypeData().getElementValueAsString(0);
    }

    public java.lang.String getCarrier_Name() {
        return (java.lang.String)baseTypeData().getElementValueAsString(1);
    }

    public MetaData metadata() {
        return metadata;
    }

    public void setCarrier_Name(java.lang.String Carrier_Name) {
        baseTypeData().setElementValue(1, Carrier_Name);
    }

    public void setCarrier(java.lang.String Carrier) {
        baseTypeData().setElementValue(0, Carrier);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Yst_Bapi_Carri_InfoType parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Yst_Bapi_Carri_InfoType parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCarrier() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCarrier_Name() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
    }

}
