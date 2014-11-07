package com.kcdata.abe.bapi;
public class Z_Api_Orig_Dest_Validate_PortType extends com.sap.aii.proxy.framework.core.AbstractProxy{

    private  static final com.sap.aii.proxy.framework.core.BaseProxyDescriptor staticDescriptor = com.sap.aii.proxy.framework.core.BaseProxyDescriptorFactory.createNewBaseProxyDescriptor("urn:sap-com:document:sap:rfc:functions:Z_API_ORIG_DEST_VALIDATE.PortType", new java.lang.Object[][][]{{{"Z_API_ORIG_DEST_VALIDATE", "z_Api_Orig_Dest_Validate", "Z_API_ORIG_DEST_VALIDATE"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_ORIG_DEST_VALIDATE.Input", "com.kcdata.abe.bapi.Z_Api_Orig_Dest_Validate_Input"}, {"urn:sap-com:document:sap:rfc:functions:Z_API_ORIG_DEST_VALIDATE.Output", "com.kcdata.abe.bapi.Z_Api_Orig_Dest_Validate_Output"}}}, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, com.kcdata.abe.bapi.Z_Api_Orig_Dest_Validate_PortType.class) ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1318915528881L) ;

    public  Z_Api_Orig_Dest_Validate_PortType () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Z_Api_Orig_Dest_Validate_Output z_Api_Orig_Dest_Validate(com.kcdata.abe.bapi.Z_Api_Orig_Dest_Validate_Input Z_Api_Orig_Dest_Validate_Input) throws com.sap.aii.proxy.framework.core.ApplicationFaultException, com.sap.aii.proxy.framework.core.SystemFaultException{
        com.sap.aii.proxy.framework.core.BaseType $result = null;
        try {
        $result = send$(Z_Api_Orig_Dest_Validate_Input, "urn:sap-com:document:sap:rfc:functions", "Z_API_ORIG_DEST_VALIDATE.PortType", "Z_API_ORIG_DEST_VALIDATE", new com.kcdata.abe.bapi.Z_Api_Orig_Dest_Validate_Output());
        }catch (com.sap.aii.proxy.framework.core.ApplicationFaultException e){
         throw createExceptionWrongExceptionType$(e);}
        if (($result == null) || ($result instanceof com.kcdata.abe.bapi.Z_Api_Orig_Dest_Validate_Output)){
        return (com.kcdata.abe.bapi.Z_Api_Orig_Dest_Validate_Output)$result;
        } else { throw createExceptionWrongType$($result);}
    }

}
