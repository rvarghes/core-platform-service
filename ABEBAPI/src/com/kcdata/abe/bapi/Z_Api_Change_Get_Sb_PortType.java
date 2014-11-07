package com.kcdata.abe.bapi;
public class Z_Api_Change_Get_Sb_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Z_API_CHANGE_GET_SB.PortType", new java.lang.Object[][][]{{{"Z_API_CHANGE_GET_SB", "z_Api_Change_Get_Sb", "Z_API_CHANGE_GET_SB"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_CHANGE_GET_SB.Input", "com.kcdata.abe.bapi.Z_Api_Change_Get_Sb_Input"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_CHANGE_GET_SB.Output", "com.kcdata.abe.bapi.Z_Api_Change_Get_Sb_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Z_Api_Change_Get_Sb_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1321529460412L) ;

    public  Z_Api_Change_Get_Sb_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Z_Api_Change_Get_Sb_Output z_Api_Change_Get_Sb(com.kcdata.abe.bapi.Z_Api_Change_Get_Sb_Input Z_Api_Change_Get_Sb_Input) throws com.sap.aii.proxy.framework.core.ApplicationFaultException, com.sap.aii.proxy.framework.core.SystemFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Z_Api_Change_Get_Sb_Input, "urn:sap-com:document:sap:rfc:functions", "Z_API_CHANGE_GET_SB.PortType", "Z_API_CHANGE_GET_SB", new com.kcdata.abe.bapi.Z_Api_Change_Get_Sb_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Z_Api_Change_Get_Sb_Output)){
        return (com.kcdata.abe.bapi.Z_Api_Change_Get_Sb_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
