package com.kcdata.abe.bapi.util;
public class Yst_Ota_Htl_ItemsType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -1944040013L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_HTL_ITEMS", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType.class, new com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType(), new java.lang.String[][]{}, 1994, 3860, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_OTA_HTL_ITEMS\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">OTA Hotel Items</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>1994</ifr:internalLength1><ifr:internalLength2>3860</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Ota_Htl_ItemsType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean containsYst_Ota_Htl_ItemsType(com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType setYst_Ota_Htl_ItemsType(int index, com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType item) {
        return (com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType)baseList().set(index, item);
    }

    public void addYst_Ota_Htl_ItemsType(int index, com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType removeYst_Ota_Htl_ItemsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType[] toArrayYst_Ota_Htl_ItemsType() {
        return (com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType[] {});
    }

    public int lastIndexOfYst_Ota_Htl_ItemsType(com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType item) {
        return baseList().lastIndexOf(item);
    }

    public Yst_Ota_Htl_ItemsType_List subListYst_Ota_Htl_ItemsType(int fromIndex, int toIndex) {
        return (Yst_Ota_Htl_ItemsType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addAllYst_Ota_Htl_ItemsType(int index, Yst_Ota_Htl_ItemsType_List item) {
        baseList().addAll(index, item);
    }

    public void addAllYst_Ota_Htl_ItemsType(Yst_Ota_Htl_ItemsType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType getYst_Ota_Htl_ItemsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType)baseList().get(index);
    }

    public boolean containsAllYst_Ota_Htl_ItemsType(Yst_Ota_Htl_ItemsType_List item) {
        return baseList().containsAll(item);
    }

    public int indexOfYst_Ota_Htl_ItemsType(com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType item) {
        return baseList().indexOf(item);
    }

    public boolean removeYst_Ota_Htl_ItemsType(com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType item) {
        return baseList().remove(item);
    }

    public void addYst_Ota_Htl_ItemsType(com.kcdata.abe.bapi.Yst_Ota_Htl_ItemsType item) {
        baseList().add(item);
    }

}
