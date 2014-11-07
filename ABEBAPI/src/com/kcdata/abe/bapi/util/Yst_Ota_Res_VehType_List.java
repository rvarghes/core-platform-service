package com.kcdata.abe.bapi.util;
public class Yst_Ota_Res_VehType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 247516940L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_RES_VEH", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Ota_Res_VehType.class, new com.kcdata.abe.bapi.Yst_Ota_Res_VehType(), new java.lang.String[][]{}, 612, 1184, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_OTA_RES_VEH\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Vehicle Items</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>612</ifr:internalLength1><ifr:internalLength2>1184</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Ota_Res_VehType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean containsAllYst_Ota_Res_VehType(Yst_Ota_Res_VehType_List item) {
        return baseList().containsAll(item);
    }

    public Yst_Ota_Res_VehType_List subListYst_Ota_Res_VehType(int fromIndex, int toIndex) {
        return (Yst_Ota_Res_VehType_List)baseList().subList(fromIndex, toIndex);
    }

    public int indexOfYst_Ota_Res_VehType(com.kcdata.abe.bapi.Yst_Ota_Res_VehType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_VehType getYst_Ota_Res_VehType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_VehType)baseList().get(index);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_VehType[] toArrayYst_Ota_Res_VehType() {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_VehType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Ota_Res_VehType[] {});
    }

    public boolean removeYst_Ota_Res_VehType(com.kcdata.abe.bapi.Yst_Ota_Res_VehType item) {
        return baseList().remove(item);
    }

    public void addYst_Ota_Res_VehType(com.kcdata.abe.bapi.Yst_Ota_Res_VehType item) {
        baseList().add(item);
    }

    public boolean containsYst_Ota_Res_VehType(com.kcdata.abe.bapi.Yst_Ota_Res_VehType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_VehType setYst_Ota_Res_VehType(int index, com.kcdata.abe.bapi.Yst_Ota_Res_VehType item) {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_VehType)baseList().set(index, item);
    }

    public void addYst_Ota_Res_VehType(int index, com.kcdata.abe.bapi.Yst_Ota_Res_VehType item) {
        baseList().add(index, item);
    }

    public void addAllYst_Ota_Res_VehType(int index, Yst_Ota_Res_VehType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_VehType removeYst_Ota_Res_VehType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_VehType)baseList().remove(index);
    }

    public int lastIndexOfYst_Ota_Res_VehType(com.kcdata.abe.bapi.Yst_Ota_Res_VehType item) {
        return baseList().lastIndexOf(item);
    }

    public void addAllYst_Ota_Res_VehType(Yst_Ota_Res_VehType_List item) {
        baseList().addAll(item);
    }

}
