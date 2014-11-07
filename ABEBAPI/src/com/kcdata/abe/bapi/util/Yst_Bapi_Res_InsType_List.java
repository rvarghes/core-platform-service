package com.kcdata.abe.bapi.util;
public class Yst_Bapi_Res_InsType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -1329401497L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_RES_INS", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Bapi_Res_InsType.class, new com.kcdata.abe.bapi.Yst_Bapi_Res_InsType(), new java.lang.String[][]{}, 570, 1120, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_RES_INS\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Insurance items</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>570</ifr:internalLength1><ifr:internalLength2>1120</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Bapi_Res_InsType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Res_InsType removeYst_Bapi_Res_InsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Res_InsType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Res_InsType setYst_Bapi_Res_InsType(int index, com.kcdata.abe.bapi.Yst_Bapi_Res_InsType item) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Res_InsType)baseList().set(index, item);
    }

    public void addYst_Bapi_Res_InsType(int index, com.kcdata.abe.bapi.Yst_Bapi_Res_InsType item) {
        baseList().add(index, item);
    }

    public void addAllYst_Bapi_Res_InsType(Yst_Bapi_Res_InsType_List item) {
        baseList().addAll(item);
    }

    public boolean removeYst_Bapi_Res_InsType(com.kcdata.abe.bapi.Yst_Bapi_Res_InsType item) {
        return baseList().remove(item);
    }

    public boolean containsAllYst_Bapi_Res_InsType(Yst_Bapi_Res_InsType_List item) {
        return baseList().containsAll(item);
    }

    public void addYst_Bapi_Res_InsType(com.kcdata.abe.bapi.Yst_Bapi_Res_InsType item) {
        baseList().add(item);
    }

    public void addAllYst_Bapi_Res_InsType(int index, Yst_Bapi_Res_InsType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsYst_Bapi_Res_InsType(com.kcdata.abe.bapi.Yst_Bapi_Res_InsType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Res_InsType getYst_Bapi_Res_InsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Res_InsType)baseList().get(index);
    }

    public int lastIndexOfYst_Bapi_Res_InsType(com.kcdata.abe.bapi.Yst_Bapi_Res_InsType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Res_InsType[] toArrayYst_Bapi_Res_InsType() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Res_InsType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Bapi_Res_InsType[] {});
    }

    public Yst_Bapi_Res_InsType_List subListYst_Bapi_Res_InsType(int fromIndex, int toIndex) {
        return (Yst_Bapi_Res_InsType_List)baseList().subList(fromIndex, toIndex);
    }

    public int indexOfYst_Bapi_Res_InsType(com.kcdata.abe.bapi.Yst_Bapi_Res_InsType item) {
        return baseList().indexOf(item);
    }

}
