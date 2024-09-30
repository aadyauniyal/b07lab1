package b07lab;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


class Polynomial{

double [] coeff;
int [] power;

Polynomial()
{
	this.coeff=new double[0];
	this.power=new int[0];
}

Polynomial(double co[], int po[])
{  coeff=co;
	power=po;
}

Polynomial(File note) throws FileNotFoundException 
{Scanner sc=new Scanner(note);
String str=sc.nextLine();
String[] poly=str.split("+-");
int len=poly.length;
for(int i=0;i<poly.length;i++)
{	String term=poly[i];
	int index=poly[i].indexOf('x');
	if(index==-1)
	{
		power[i]=0;
		coeff[i]=Double.parseDouble(poly[i]);
			
	}
	else
	{String coef = poly[i].substring(0, index);
    if (coef==" ") {
        coeff[i] = 1; 
    }  else {
        coeff[i] = Double.parseDouble(coef); 
    }

    if (poly[i].substring(0, index)!="") {
        power[i] = Integer.parseInt(poly[i].substring(index + 1).trim()); 
        coeff[i] = Double.parseDouble(poly[i].substring(0, index).trim()); 
    } else {
        power[i] = 1; 
        coeff[i] = Double.parseDouble(poly[i].substring(0, index).trim()); 
    }

}
}
sc.close();}


public int findmax(int a[])
{  int max=a[0]; 
	for(int i=0;i<a.length;i++)
	{
		if(a[i]>max)
		{
			max=a[i];
		}
	}
	return max;
}

public Polynomial add(Polynomial poly)
{
 
int max1 = findmax(this.power);
int max2 = findmax(poly.power);
int totallen = max1;
if (totallen < max2) totallen = max2;
    double[] addCoeff = new double[totallen+1]; 
    int[] addPower = new int[totallen+1];
	int i = 0; 
	while(i <= totallen)  {
    addPower[i] = i;  
    addCoeff[i] = 0;  
    i++;
    }
    for ( i = 0; i <= totallen; i++) {
    if (i < poly.power.length && poly.power[i] == addPower[i]) {
        addCoeff[i] += poly.coeff[i]; 
        }
    if (i < this.power.length && this.power[i] == addPower[i]) {
        addCoeff[i] += this.coeff[i]; 
    }}
    return new Polynomial(addCoeff, addPower);
}

public double evaluate(double x)
{
double sum=0;
for(int i=0;i<coeff.length;i++)
{ sum = sum + coeff[i]* Math.pow(x,power[i]);
}
return sum;
}

public boolean hasRoot(double x)
{
if(evaluate(x)==0) return true;
else return false;
}

Polynomial multiply(Polynomial poly) {
	int max1 = findmax(this.power);
	int max2 = findmax(poly.power);
	int totallen = max1+max2;
	double[] mulCoeff = new double[totallen+1]; 
    int[] mulPower = new int[totallen+1];
	int i = 0; 
	while(i <= totallen)  {
    mulPower[i] = i;  
    mulCoeff[i] = 0;  
    i++;
    }
    for (i = 0; i < this.power.length; i++) {
        for (int j = 0; j < poly.power.length; j++) {
            if (this.power[i] + poly.power[j] == mulPower[this.power[i] + poly.power[j]]) {
                mulCoeff[this.power[i] + poly.power[j]] += this.coeff[i] * poly.coeff[j];
            }
        }
    }

	return new Polynomial(mulCoeff, mulPower);
}

public void saveToFile(String str) throws IOException{
	FileWriter output= new FileWriter(str, true);
	for(int i=0;i<power.length;i++) {
		if(coeff[i]!=0 && power[i]!=0 && i!=power.length-1) {
			
		}
		if(coeff[i]!=0 && power[i]==0)
		{output.write(Double.toString(coeff[i]));
		}
		if(coeff[i]!=0 && power[i]!=0 && i!=power.length-2)
		{	String s= Double.toString(coeff[i])+"x"+Double.toString(power[i]);
        if (i > 0 && coeff[i] > 0) {
            output.write("+");
        }

        output.write(s); 
		}
		
	}
	output.close();
}
}
