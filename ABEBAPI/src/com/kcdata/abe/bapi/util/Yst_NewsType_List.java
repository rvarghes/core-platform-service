package com.kcdata.abe.bapi.util;
public class Yst_NewsType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -1658220814L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_NEWS", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_NewsType.class, new com.kcdata.abe.bapi.Yst_NewsType(), new java.lang.String[][]{}, 258, 516, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_NEWS\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Tour Operation News and Message</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>258</ifr:internalLength1><ifr:internalLength2>516</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_NewsType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_NewsType removeYst_NewsType(int index) {
        return (com.kcdata.abe.bapi.Yst_NewsType)baseList().remove(index);
    }

    public Yst_NewsType_List subListYst_NewsType(int fromIndex, int toIndex) {
        return (Yst_NewsType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addAllYst_NewsType(Yst_NewsType_List item) {
        baseList().addAll(item);
    }

    public boolean removeYst_NewsType(com.kcdata.abe.bapi.Yst_NewsType item) {
        return baseList().remove(item);
    }

    public com.kcdata.abe.bapi.Yst_NewsType setYst_NewsType(int index, com.kcdata.abe.bapi.Yst_NewsType item) {
        return (com.kcdata.abe.bapi.Yst_NewsType)baseList().set(index, item);
    }

    public boolean containsYst_NewsType(com.kcdata.abe.bapi.Yst_NewsType item) {
        return baseList().contains(item);
    }

    public void addAllYst_NewsType(int index, Yst_NewsType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsAllYst_NewsType(Yst_NewsType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.Yst_NewsType[] toArrayYst_NewsType() {
        return (com.kcdata.abe.bapi.Yst_NewsType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_NewsType[] {});
    }

    public com.kcdata.abe.bapi.Yst_NewsType getYst_NewsType(int index) {
        return (com.kcdata.abe.bapi.Yst_NewsType)baseList().get(index);
    }

    public int lastIndexOfYst_NewsType(com.kcdata.abe.bapi.Yst_NewsType item) {
        return baseList().lastIndexOf(item);
    }

    public void addYst_NewsType(com.kcdata.abe.bapi.Yst_NewsType item) {
        baseList().add(item);
    }

    public int indexOfYst_NewsType(com.kcdata.abe.bapi.Yst_NewsType item) {
        return baseList().indexOf(item);
    }

    public void addYst_NewsType(int index, com.kcdata.abe.bapi.Yst_NewsType item) {
        baseList().add(index, item);
    }

}
