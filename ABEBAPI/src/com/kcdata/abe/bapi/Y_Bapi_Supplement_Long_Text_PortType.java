package com.kcdata.abe.bapi;
public class Y_Bapi_Supplement_Long_Text_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Bapi_Supplement_Long_Text.PortType", new java.lang.Object[][][]{{{"Y_BAPI_SUPPLEMENT_LONG_TEXT", "y_Bapi_Supplement_Long_Text", "Y_BAPI_SUPPLEMENT_LONG_TEXT"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_SUPPLEMENT_LONG_TEXT.Input", "com.kcdata.abe.bapi.Y_Bapi_Supplement_Long_Text_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_SUPPLEMENT_LONG_TEXT.Output", "com.kcdata.abe.bapi.Y_Bapi_Supplement_Long_Text_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Bapi_Supplement_Long_Text_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1256083563750L) ;

    public  Y_Bapi_Supplement_Long_Text_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Bapi_Supplement_Long_Text_Output y_Bapi_Supplement_Long_Text(com.kcdata.abe.bapi.Y_Bapi_Supplement_Long_Text_Input Y_Bapi_Supplement_Long_Text_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Bapi_Supplement_Long_Text_Input, "urn:sap-com:document:sap:rfc:functions", "Y_Bapi_Supplement_Long_Text.PortType", "Y_BAPI_SUPPLEMENT_LONG_TEXT", new com.kcdata.abe.bapi.Y_Bapi_Supplement_Long_Text_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Bapi_Supplement_Long_Text_Output)){
        return (com.kcdata.abe.bapi.Y_Bapi_Supplement_Long_Text_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
