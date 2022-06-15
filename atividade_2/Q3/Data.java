class Data {
    int dia;
    int mes;
    int ano;

    public boolean vemAntes(Data data2) {
        if (this.ano < data2.ano) {
            return true;
        }
        else if (this.ano > data2.ano){
            return false;
        }
        else if ((this.ano == data2.ano) && (this.mes < data2.mes)){
            return true;
        }
        else if ((this.ano == data2.ano) && (this.mes > data2.mes)){
            return false;
        }
        else if ((this.ano == data2.ano) && (this.mes == data2.mes) && (this.dia < data2.dia)){
            return true;
        }
        else if ((this.ano == data2.ano) && (this.mes == data2.mes) && (this.dia > data2.dia)){
            return false;
        }
        else {
            return true;
        }

    }
}
