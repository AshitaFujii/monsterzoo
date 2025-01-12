import java.util.ArrayList;

public class MonsterZoo {
	double distance=0.0;//歩いた距離
	int balls=10;//モンスターを捕まえられるボールの数
	int fruits=0;//ぶつけるとモンスターが捕まえやすくなるフルーツ

	//卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
	//移動するたびに,eggDistanceに1.0kmずつ加算される．
	//3km移動するとランダムでモンスターが孵る
	ArrayList<Egg> egg = new ArrayList<Egg>();

	//ユーザがGetしたモンスター一覧
	ArrayList<Monster> userMonster = new ArrayList<Monster>();

	//モンスター図鑑．モンスターの名前とレア度(0.0~9.0)がそれぞれの配列に保存されている
	//レア度が高いほうが捕まえにくい
	ArrayList<Monster> monsterZukan;

	//呼び出すと1km distanceが増える
	void move(){
		this.distance++;
		updateEgg();

		int flg1 = (int)(Math.random()*10);//0,1の場合はズーstation，7~9の場合はモンスター
		if(flg1<=1){
			zooStation();
		}else if(flg1>=7){
			battle();
		}
		egg();
	}

	public double getDistance() {
		return distance;
	}

	public int getBalls() {
		return balls;
	}

	public int getFruits() {
		return fruits;
	}

	public ArrayList<Monster> getUserMonster() {
		return userMonster;
	}

	public void setMonsterZukan(ArrayList<Monster> monsterZukan) {
		this.monsterZukan = monsterZukan;
	}

	public void zooStation(){
		System.out.println("ズーstationを見つけた！");
		int b=(int)(Math.random()*3);//ball,fruits,eggがランダムに出る
		int f=(int)(Math.random()*2);
		int e=(int)(Math.random()*2);
		System.out.println("ボールを"+b+"個，"+"フルーツを"+f+"個"+"卵を"+e+"個Getした！");
		this.balls=this.balls+b;
		this.fruits=this.fruits+f;
		if(e>=1){//卵を1つ以上Getしたら
			//egg[]に10個以上卵がない場合は新しい卵データをセットする
			if(egg.size() < 10){
				egg.add(new Egg());
			}
		}
	}

	public void updateEgg(){
		for(Egg e : egg){//卵は移動距離が進むと孵化するため，何km移動したかを更新する
			e.distance++;
		}
	}

	public void egg(){
		for(Egg e : egg){
			if(e.distance >= 3){
				System.out.println("卵が孵った！");
				int m = (int)(this.monsterZukan.size()*Math.random());
				System.out.println(this.monsterZukan.get(m).name+"が産まれた！");

				this.userMonster.add(this.monsterZukan.get(m));
			}
		}
	}

	public void battle(){
		int m = (int)(this.monsterZukan.size()*Math.random());//monsterZukanからランダムにモンスターを出す
		System.out.println(this.monsterZukan.get(m).name+"が現れた！");
		for(int i=0;i<3&&this.balls>0;i++){//捕まえる or 3回ボールを投げるまで繰り返す
			int r = (int)(6*Math.random());//0~5までの数字をランダムに返す
			if(this.fruits>0){
				System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
				this.fruits--;
				r = r * 2;
			}
			System.out.println(this.monsterZukan.get(m).name+"にボールを投げた");
			this.balls--;
			if(this.monsterZukan.get(m).rare<=r){//monsterRare[m]の値がr以下の場合
				System.out.println(this.monsterZukan.get(m).name+"を捕まえた！");
				this.userMonster.add(this.monsterZukan.get(m));
				break;//ボール投げ終了
			}else{
				System.out.println(this.monsterZukan.get(m).name+"に逃げられた！");
			}
		}
	}
}
