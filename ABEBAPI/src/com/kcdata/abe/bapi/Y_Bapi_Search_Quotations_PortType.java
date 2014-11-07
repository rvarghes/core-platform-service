package com.kcdata.abe.bapi;
public class Y_Bapi_Search_Quotations_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Bapi_Search_Quotations.PortType", new java.lang.Object[][][]{{{"Y_BAPI_SEARCH_QUOTATIONS", "y_Bapi_Search_Quotations", "Y_BAPI_SEARCH_QUOTATIONS"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_SEARCH_QUOTATIONS.Input", "com.kcdata.abe.bapi.Y_Bapi_Search_Quotations_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_SEARCH_QUOTATIONS.Output", "com.kcdata.abe.bapi.Y_Bapi_Search_Quotations_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Bapi_Search_Quotations_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1269957626109L) ;

    public  Y_Bapi_Search_Quotations_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Bapi_Search_Quotations_Output y_Bapi_Search_Quotations(com.kcdata.abe.bapi.Y_Bapi_Search_Quotations_Input Y_Bapi_Search_Quotations_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Bapi_Search_Quotations_Input, "urn:sap-com:document:sap:rfc:functions", "Y_Bapi_Search_Quotations.PortType", "Y_BAPI_SEARCH_QUOTATIONS", new com.kcdata.abe.bapi.Y_Bapi_Search_Quotations_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Bapi_Search_Quotations_Output)){
        return (com.kcdata.abe.bapi.Y_Bapi_Search_Quotations_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
