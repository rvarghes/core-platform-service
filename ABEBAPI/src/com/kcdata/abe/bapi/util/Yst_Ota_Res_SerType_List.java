package com.kcdata.abe.bapi.util;
public class Yst_Ota_Res_SerType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 1889208403L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_RES_SER", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Ota_Res_SerType.class, new com.kcdata.abe.bapi.Yst_Ota_Res_SerType(), new java.lang.String[][]{}, 532, 1048, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_OTA_RES_SER\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Services items</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>532</ifr:internalLength1><ifr:internalLength2>1048</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Ota_Res_SerType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean containsYst_Ota_Res_SerType(com.kcdata.abe.bapi.Yst_Ota_Res_SerType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_SerType setYst_Ota_Res_SerType(int index, com.kcdata.abe.bapi.Yst_Ota_Res_SerType item) {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_SerType)baseList().set(index, item);
    }

    public void addYst_Ota_Res_SerType(int index, com.kcdata.abe.bapi.Yst_Ota_Res_SerType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_SerType removeYst_Ota_Res_SerType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_SerType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_SerType[] toArrayYst_Ota_Res_SerType() {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_SerType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Ota_Res_SerType[] {});
    }

    public int lastIndexOfYst_Ota_Res_SerType(com.kcdata.abe.bapi.Yst_Ota_Res_SerType item) {
        return baseList().lastIndexOf(item);
    }

    public Yst_Ota_Res_SerType_List subListYst_Ota_Res_SerType(int fromIndex, int toIndex) {
        return (Yst_Ota_Res_SerType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addAllYst_Ota_Res_SerType(int index, Yst_Ota_Res_SerType_List item) {
        baseList().addAll(index, item);
    }

    public void addAllYst_Ota_Res_SerType(Yst_Ota_Res_SerType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Res_SerType getYst_Ota_Res_SerType(int index) {
        return (com.kcdata.abe.bapi.Yst_Ota_Res_SerType)baseList().get(index);
    }

    public boolean containsAllYst_Ota_Res_SerType(Yst_Ota_Res_SerType_List item) {
        return baseList().containsAll(item);
    }

    public int indexOfYst_Ota_Res_SerType(com.kcdata.abe.bapi.Yst_Ota_Res_SerType item) {
        return baseList().indexOf(item);
    }

    public boolean removeYst_Ota_Res_SerType(com.kcdata.abe.bapi.Yst_Ota_Res_SerType item) {
        return baseList().remove(item);
    }

    public void addYst_Ota_Res_SerType(com.kcdata.abe.bapi.Yst_Ota_Res_SerType item) {
        baseList().add(item);
    }

}
