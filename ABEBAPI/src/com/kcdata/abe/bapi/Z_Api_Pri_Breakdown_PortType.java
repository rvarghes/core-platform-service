package com.kcdata.abe.bapi;
public class Z_Api_Pri_Breakdown_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Z_Api_Pri_Breakdown.PortType", new java.lang.Object[][][]{{{"Z_API_PRI_BREAKDOWN", "z_Api_Pri_Breakdown", "Z_API_PRI_BREAKDOWN"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_PRI_BREAKDOWN.Input", "com.kcdata.abe.bapi.Z_Api_Pri_Breakdown_Input"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_PRI_BREAKDOWN.Output", "com.kcdata.abe.bapi.Z_Api_Pri_Breakdown_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Z_Api_Pri_Breakdown_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1291331393140L) ;

    public  Z_Api_Pri_Breakdown_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Z_Api_Pri_Breakdown_Output z_Api_Pri_Breakdown(com.kcdata.abe.bapi.Z_Api_Pri_Breakdown_Input Z_Api_Pri_Breakdown_Input) throws com.sap.aii.proxy.framework.core.SystemFaultException, com.sap.aii.proxy.framework.core.ApplicationFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Z_Api_Pri_Breakdown_Input, "urn:sap-com:document:sap:rfc:functions", "Z_Api_Pri_Breakdown.PortType", "Z_API_PRI_BREAKDOWN", new com.kcdata.abe.bapi.Z_Api_Pri_Breakdown_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Z_Api_Pri_Breakdown_Output)){
        return (com.kcdata.abe.bapi.Z_Api_Pri_Breakdown_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
