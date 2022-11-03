//配列をArrayListに変更
//クラスを作成して変数をまとめる
//メソッドに置き換える

import java.util.ArrayList;

public class Main {
	static MonsterZoo pz = new MonsterZoo();

	public static void main(String[] args) {

		setMonsterZukan();

		//1000ミリ秒（1秒）ずつ止まりながらpz.move()を呼び出し続ける
		//手持ちのボールが無くなったら終了
		while(true){
			try {
				Thread.sleep(1000);
				if(pz.getBalls()>0){
					pz.move();
					System.out.println("手持ちのボールは"+pz.getBalls()+"個，フルーツは"+pz.getFruits()+"個");
					System.out.println(pz.getDistance()+"km歩いた．");
				}else{
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("ボールがなくなった！");

		for(Monster mon : pz.getUserMonster()){
			System.out.println(mon.name+"を捕まえた．");
		}
	}

	//テスト用のモンスターデータを登録するメソッド
	public static void setMonsterZukan(){
		ArrayList<Monster> monsterZukan = new ArrayList<Monster>();
		monsterZukan.add(new Monster("イガキン", 9));
		monsterZukan.add(new Monster("ナマチュウ", 3));
		monsterZukan.add(new Monster("イノウエン", 1));
		monsterZukan.add(new Monster("リョージィ", 2));
		monsterZukan.add(new Monster("アキモトン", 5));
		monsterZukan.add(new Monster("ゴージマ", 4));
		monsterZukan.add(new Monster("チュウデン", 6));
		monsterZukan.add(new Monster("ヅカホン", 8));
		monsterZukan.add(new Monster("ニシムラー", 7));
		monsterZukan.add(new Monster("サコーデン", 2));
		monsterZukan.add(new Monster("ウッチー", 5));
		monsterZukan.add(new Monster("ハヤッシー", 4));
		monsterZukan.add(new Monster("キーチー", 3));
		monsterZukan.add(new Monster("リョクン", 1));
		monsterZukan.add(new Monster("デコポン", 6));
		monsterZukan.add(new Monster("カミサン", 5));
		monsterZukan.add(new Monster("シスイ", 1));
		monsterZukan.add(new Monster("ジョナ", 7));
		monsterZukan.add(new Monster("ギダギダ", 2));
		monsterZukan.add(new Monster("ミッツー", 8));
		monsterZukan.add(new Monster("ゾエサン", 5));
		monsterZukan.add(new Monster("キタバー", 3));

		pz.setMonsterZukan(monsterZukan);
	}

}
