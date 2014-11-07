package com.kcdata.abe.bapi.util;
public class Yst_Ota_Res_HotelsType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -1848388128L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_RES_HOTELS", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType.class, new com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType(), new java.lang.String[][]{}, 876, 1712, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_OTA_RES_HOTELS\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">OTA Hotel Items</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>876</ifr:internalLength1><ifr:internalLength2>1712</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Ota_Res_HotelsType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType setYst_Ota_Res_HotelsType(int index, com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType item) {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType)baseList().set(index, item);
    }

    public void addYst_Ota_Res_HotelsType(int index, com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType item) {
        baseList().add(index, item);
    }

    public void addAllYst_Ota_Res_HotelsType(Yst_Ota_Res_HotelsType_List item) {
        baseList().addAll(item);
    }

    public boolean removeYst_Ota_Res_HotelsType(com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType item) {
        return baseList().remove(item);
    }

    public boolean containsAllYst_Ota_Res_HotelsType(Yst_Ota_Res_HotelsType_List item) {
        return baseList().containsAll(item);
    }

    public void addYst_Ota_Res_HotelsType(com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType item) {
        baseList().add(item);
    }

    public void addAllYst_Ota_Res_HotelsType(int index, Yst_Ota_Res_HotelsType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsYst_Ota_Res_HotelsType(com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType getYst_Ota_Res_HotelsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType)baseList().get(index);
    }

    public int lastIndexOfYst_Ota_Res_HotelsType(com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType item) {
        return baseList().lastIndexOf(item);
    }

    public Yst_Ota_Res_HotelsType_List subListYst_Ota_Res_HotelsType(int fromIndex, int toIndex) {
        return (Yst_Ota_Res_HotelsType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType removeYst_Ota_Res_HotelsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType[] toArrayYst_Ota_Res_HotelsType() {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType[] {});
    }

    public int indexOfYst_Ota_Res_HotelsType(com.kcdata.abe.bapi.Yst_Ota_Res_HotelsType item) {
        return baseList().indexOf(item);
    }

}
