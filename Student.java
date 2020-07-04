class Student{
private int rno,sub1,sub2,sub3;
private String name;

public Student()
{
rno=0;
name="";
sub1=0;
sub2=0;
sub3=0;
}

public Student(int rno,String name,int sub1,int sub2,int sub3)
{
this.rno=rno;
this.name=name;
this.sub1=sub1;
this.sub2=sub2;
this.sub3=sub3;
}

public int getRno(){	//Accessor
return rno;
}
public void setRno(int rno){	//Mutator
this.rno=rno;
}

public String getName(){
	return name;
}
public void setName(String name){
	this.name=name;
}

public int getsub1(){	//Accessor
return sub1;
}
public void setsub1(int sub1){	//Mutator
this.sub1=sub1;
}

public int getsub2(){	//Accessor
return sub2;
}
public void setsub2(int sub2){	//Mutator
this.sub2=sub2;
}

public int getsub3(){	//Accessor
return sub3;
}
public void setsub3(int sub3){	//Mutator
this.sub3=sub3;
}

}