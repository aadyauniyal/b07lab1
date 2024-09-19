
class Polynomial{

double [] arr;

Polynomial()
{
	this.arr=new double[0];
}

Polynomial(double ar[])
{ arr = ar;
}

public Polynomial add(Polynomial poly)
{
 
int total_len = poly.arr.length;
if(this.arr.length>poly.arr.length)
 total_len=this.arr.length;
double [] added= new double[total_len];
for (int i = 0; i < total_len; i++) {
	if (i < this.arr.length && i < poly.arr.length)
		added[i] = this.arr[i] + poly.arr[i];
    else if (i >= this.arr.length) 
	added[i] = poly.arr[i];
    else
	added[i] = this.arr[i];
        }
return new Polynomial(added);
}

public double evaluate(double x)
{
double sum=0;
for(int i=0;i<arr.length;i++)
{ sum = sum + arr[i]* Math.pow(x,i);
}
return sum;
}

public boolean hasRoot(double x)
{
if(evaluate(x)==0) return true;
else return false;
}

}





