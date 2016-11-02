/*
 # ===================================================
 # Intertec
 # ***************************************************
 # Projeto: Intertec Test
 # Programmer: Weverton de Souza Castanho
 # Data: 11.01.2016
 # =================================================== 
 */
package com.intertec.test.model;

public class PropertiesTO {

    private String jdbcDriver;
    private String databaseUrl;
    private String databaseUser;
    private String databaseDirectory;
    private String databasePassword;
    private int lineMaximum;
    private String logUrl;
    private String EndPointExecuteScript;
    private String verifyUpdateScriptUrl;
    private String verifyUpdatePropertyUrl;
    private String verifyUpdateThresholdUrl;
    private String verifyUpdateScheduleUrl;
    private String PathScripts;
    private String PathVBScriptExec;    
    private String identification;
    private String KpiUrl;
    private String ipHostAgents;

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public void setDatabaseUser(String databaseUser) {
        this.databaseUser = databaseUser;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }

    public int getLineMaximum() {
        return lineMaximum;
    }

    public void setLineMaximum(int lineMaximum) {
        this.lineMaximum = lineMaximum;
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    public String getEndPointExecuteScript() {
        return EndPointExecuteScript;
    }

    public void setEndPointExecuteScript(String EndPointExecuteScript) {
        this.EndPointExecuteScript = EndPointExecuteScript;
    }

    public String getVerifyUpdateScriptUrl() {
        return verifyUpdateScriptUrl;
    }

    public void setVerifyUpdateScriptUrl(String verifyUpdateScriptUrl) {
        this.verifyUpdateScriptUrl = verifyUpdateScriptUrl;
    }

    public String getVerifyUpdatePropertyUrl() {
        return verifyUpdatePropertyUrl;
    }

    public void setVerifyUpdatePropertyUrl(String verifyUpdatePropertyUrl) {
        this.verifyUpdatePropertyUrl = verifyUpdatePropertyUrl;
    }

    public String getVerifyUpdateThresholdUrl() {
        return verifyUpdateThresholdUrl;
    }

    public void setVerifyUpdateThresholdUrl(String verifyUpdateThresholdUrl) {
        this.verifyUpdateThresholdUrl = verifyUpdateThresholdUrl;
    }

    public String getVerifyUpdateScheduleUrl() {
        return verifyUpdateScheduleUrl;
    }

    public void setVerifyUpdateScheduleUrl(String verifyUpdateScheduleUrl) {
        this.verifyUpdateScheduleUrl = verifyUpdateScheduleUrl;
    }

    public String getPathScripts() {
        return PathScripts;
    }

    public void setPathScripts(String PathScripts) {
        this.PathScripts = PathScripts;
    }    

    public String getPathVBScriptExec() {
        return PathVBScriptExec;
    }

    public void setPathVBScriptExec(String PathVBScriptExec) {
        this.PathVBScriptExec = PathVBScriptExec;
    }   

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getKpiUrl() {
        return KpiUrl;
    }

    public void setKpiUrl(String KpiUrl) {
        this.KpiUrl = KpiUrl;
    }    

    public String getIpHostAgents() {
        return ipHostAgents;
    }

    public void setIpHostAgents(String ipHostAgents) {
        this.ipHostAgents = ipHostAgents;
    }    

    public String getDatabaseDirectory() {
        return databaseDirectory;
    }

    public void setDatabaseDirectory(String databaseDirectory) {
        this.databaseDirectory = databaseDirectory;
    }    
}
