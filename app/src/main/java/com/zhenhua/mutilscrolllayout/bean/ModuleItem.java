package com.zhenhua.mutilscrolllayout.bean;

public class ModuleItem {
    private String moduleName;
    private int moduleImage;

    public ModuleItem(String moduleName, int moduleImage){
        this.moduleName = moduleName;
        this.moduleImage = moduleImage;
    }
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getModuleImage() {
        return moduleImage;
    }

    public void setModuleImage(int moduleImage) {
        this.moduleImage = moduleImage;
    }
}
