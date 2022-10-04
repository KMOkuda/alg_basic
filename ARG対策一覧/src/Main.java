public class Main {

	/*
	public static int binarySearch(int data[]) {
    	return 5;
    }
	*/


    public static void main(String[] args) {

    	/*
    	 * 基本のソート
    	 *
    	 * 暗記してもいいかもしれない。
    	 */


    	/*
         * 挿入ソート
         */

        /*
         * 位置がなかなか確定しないのが特徴。
         * 最初の方はサクサク次の要素に行くけど最後の方は挿入が大変。
         */

        int n_b = 16;
        int dataA[] = {4, 9, 12, 13, 7, 2, 7, 15, 9, 6, 1, 8, 1, 11, 5, 10};
        System.out.println("-挿入ソート-");

        for(int i = 1; i < n_b; i++) {
        	for(int j = i - 1; j >= 0; j--) {
        		//途中経過を表示
            	for(int num: dataA) {
    				System.out.print(num + " ");
    			}
            	System.out.println();

        		if(dataA[j] > dataA[j + 1]) {
        			int work = dataA[j];
        			dataA[j] = dataA[j + 1];
        			dataA[j + 1] = work;

        		}else {
        			break;
        		}

        	}
        	System.out.println();
        }

        System.out.println();

        /*
         * バブルソート
         */

        /*
         * 端から確定していくソート。最初の方は派手に移動する。
         * 最後はおとなしい。
         */

        int dataB[] = {4, 9, 12, 13, 7, 2, 7, 15, 9, 6, 1, 8, 1, 11, 5, 10};
        System.out.println("-バブルソート-");

        for(int i = 0; i < n_b - 1; i++) {
        	for(int j = n_b - 1; j > i; j--) {
        		//途中経過表示
            	for(int num: dataB) {
    				System.out.print(num + " ");
    			}
            	System.out.println();
        		if(dataB[j] <= dataB[j - 1]) {
        			int work = dataB[j];
        			dataB[j] = dataB[j - 1];
        			dataB[j - 1] = work;
        		}
        	}
        	System.out.println();
        }
        System.out.println();

        /*
         * 2分探索法。再帰関数を使わない方法はこれ
         */

        int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int idx = 0;
        int tkey = 14;//見つけたい数
        int low = 0;
        int high = 15;//要素数
        int medium = 0;

        while(idx == 0 && low <= high) {
        	medium = (low + high) / 2;
        	if(tkey == numbers[medium]) {
        		idx = medium;//見つかった
        	}else if(tkey < numbers[medium]) {
        		high = medium - 1;//低いほうにある
        	}else {
        		low = medium + 1;//高いほうにある
        	}
        }

    	/*
    	 * ここから応用！
    	 *
    	 * 画像とソート
    	 */


    	/*
    	 * 画像回転・反転のアルゴリズム
    	 */

        int n_a = 8;
        int p = 1;
        int e;

        String str = "*** ****"
	    		    + " *** ***"
	    		    + "  *** **"
	    		    + "   *** *"
	    		    + "  *** **"
	    		    + " *** ***"
	    		    + "*** ****";

        char strS[][] = new char[n_a][n_a];
        //配列に変換
        for(int i = 0; i < str.length(); i++) {
        	strS[i / n_a][i % n_a] = str.charAt(i);
        }

        char strT[][] = new char[n_a][n_a];
        //テキストp.222参照
        if(p == 1 || p == 2) {
        	e = n_a;
        }else {
        	e = n_a / 2;//上下反転の時はjのループ数が半分に
        }

        for(int j = 0; j < n_a; j++) {
        	for(int k = 0; k < n_a; k++) {
        		if(p == 1) {//左右反転
        			strT[j][n_a - k - 1] = strS[j][k];
        		}else {
        			if(p == 2) {//右回転
        				strT[k][n_a - j - 1] = strS[j][k];
        			}else {//上下反転
        				char w = strS[j][k];
        				strS[j][k] = strS[n_a - j - 1][k];
        				strS[n_a - j - 1][k] = w;
        			}
        		}
        		//左回転
        		/*
        		 * strT[n - k - 1][j] = strS[j][k];
        		 */
        	}
        }

        /*
         * TODO 画像の縮小
         */

        char strC[][] = new char[n_a * 2][n_a * 2];
        for(int i = 0; i < n_a; i++) {
        	for(int j = 0; j < n_a; j++) {
        		strC[i * 2][j * 2] = strC[i * 2][j * 2 + 1]
        		= strC[i * 2 + 1][j * 2] = strC[i * 2 + 1][j * 2 + 1] = strS[i][j];
        	}
        }


        /*
        for(int i = 0; i < strC.length; i++) {
        	for(int j = 0; j < strC[0].length; j++) {
        		System.out.print(strC[i][j]);
        	}
        	System.out.println();
        }
        */

        /*
         * TODO 縮小画像の複数表示 優先度は低そう
         */

        //画像表示
        /*
        for(int i = 0; i < strT.length; i++) {
        	for(int j = 0; j < strT[0].length; j++) {
        		System.out.print(strT[i][j]);
        	}
        	System.out.println();
        }
		*/

        /*
         * 2分探索を再帰関数を使って書くと....
         */

        //TODO 再帰関数後でやってみる
        while(idx == 0 && low <= high) {
        	medium = (low + high) / 2;
        	if(tkey == numbers[medium]) {
        		idx = medium;
        	}else if(tkey < numbers[medium]) {
        		high = medium - 1;
        	}else {
        		low = medium + 1;
        	}
        }

        /*
         *  TODO シェルソート（途中）
         */

        //貝殻とは何の関係もないらしい。器用そうな方法。

        System.out.println("-シェルソート-");
        int dataC[] = {4, 9, 12, 13, 7, 2, 7, 15, 9, 6, 1, 8, 1, 11, 5, 10};
        int n_c = 16;
        int soto, uchi, between, work, loopEsc;
        loopEsc = -9;

        between = (int)(n_c / 2);
        while(between > 0) {
        	soto = between;
        	/*
        	while(soto) {

        	}*/
        }

        /*
         *
         */


    }
}