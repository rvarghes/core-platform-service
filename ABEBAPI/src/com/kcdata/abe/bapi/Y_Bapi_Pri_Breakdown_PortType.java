package com.kcdata.abe.bapi;
public class Y_Bapi_Pri_Breakdown_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Y_Bapi_Pri_Breakdown.PortType", new java.lang.Object[][][]{{{"Y_BAPI_PRI_BREAKDOWN", "y_Bapi_Pri_Breakdown", "Y_BAPI_PRI_BREAKDOWN"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_PRI_BREAKDOWN.Input", "com.kcdata.abe.bapi.Y_Bapi_Pri_Breakdown_Input"}, {"urn:sap-com:document:sap:rfc:functions:Y_BAPI_PRI_BREAKDOWN.Output", "com.kcdata.abe.bapi.Y_Bapi_Pri_Breakdown_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Y_Bapi_Pri_Breakdown_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1299152628031L) ;

    public  Y_Bapi_Pri_Breakdown_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Y_Bapi_Pri_Breakdown_Output y_Bapi_Pri_Breakdown(com.kcdata.abe.bapi.Y_Bapi_Pri_Breakdown_Input Y_Bapi_Pri_Breakdown_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Y_Bapi_Pri_Breakdown_Input, "urn:sap-com:document:sap:rfc:functions", "Y_Bapi_Pri_Breakdown.PortType", "Y_BAPI_PRI_BREAKDOWN", new com.kcdata.abe.bapi.Y_Bapi_Pri_Breakdown_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Y_Bapi_Pri_Breakdown_Output)){
        return (com.kcdata.abe.bapi.Y_Bapi_Pri_Breakdown_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
