package java_algo.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 왕실의기사대결 {
    static int L, N, Q;
    static int[][] knight; //기사 정보 저장
    static int[][] chess; //체스판(빈칸,함정,벽)
    static int[] life;
    static int[][] dm;
    static int r,c,h,w,k;
    static int ans;
    static int[] dx = {-1,0,1,0}; //상 우 하 좌
    static int[] dy = {0,1,0,-1};
    static int[] H;
    static int[] W;
    static Queue<Integer> queN;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        chess = new int[L][L];
        knight = new int[L][L];
        dm = new int[N][Q];//n번째 기사의 q 공격시 dm
        life = new int[N]; //기사 수
        queN = new LinkedList<>();
        H = new int[N];
        W = new int[N];

        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<L;j++){
                chess[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());



            for(int j=r-1;j<r-1+h;j++){
                for(int l=c-1;l<c-1+w;l++){
                    knight[j][l] =  i+1 ; //i+1번째 기사 기록

                }
            }
            life[i] = k; //초기 체력 입력
        }
        //printMap();
        //System.out.println();
        //Q번 공격
        for(int i=0;i<Q;i++){
            queN = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());//기사
            int di = Integer.parseInt(st.nextToken()); //방향

            if(cango(num,di)){
                //System.out.println((i+1)+"번째Q: "+ "감" +",방향:"+di);
                move(di);
                getDemage(num,i);
            }

        }
        //printMap();

        getTotal();
        System.out.println(ans);
    }
    //num은 지금 싸우는 기사, attack은지금 몇트째 싸우고 있는지 숫자
    private static void getDemage(int num, int attack) {
        for(int i=0;i<L;i++) {
            for(int j=0;j<L;j++) {

                // 각병사가 있는 위치해있고,현재 공격의 한 병사의 숫자가
                // 아닐경우와 아까 queN에담겻을경우 만 데미지 입음
                //System.out.println("이번에 볼거는용 : "+ knight[i][j]);
                if(knight[i][j]!=0 && knight[i][j]!=num && queN.contains(knight[i][j])) {
                    //System.out.println("이번에 볼거는용 : "+ knight[i][j]);
                    //함정이 있을 경우 체력 감소
                    if(chess[i][j]==1) {
                        int now = knight[i][j]-1; // 몇번쨰 병사~?
                        life[now] --;
                        // 기사 죽으면 아웃
                        if(life[now]<=0) {
                            out(now);
                            Arrays.fill(dm[now], 0);

                        }else {
                            dm[now][attack]++;
                            //System.out.println("아파용 ");
                        }


                    }
                }

            }
        }
    }
    private static void out(int now) {
        now= now+1;
        //n번째 기사 사망
        for(int i=0;i<L;i++) {
            for(int j=0;j<L;j++) {
                if(knight[i][j]==now) {
                    knight[i][j]=0;
                }
            }
        }

//    	System.out.println(now+"번째 병사 아웃: !!! ");
//    	System.out.println("----------- ");
//    	printMap();
//    	System.out.println("----------- ");

    }
    private static void move(int dir) {
        int[][] knight2 = new int[L][L];
        boolean[][] visit = new boolean[L][L];

        for(int i=0;i<L;i++) {
            for(int j=0;j<L;j++) {
                // 지금 병사가 위치해 있고, 그병사가 방금 que에 담았떤 숫자라면 ! (한번이라도 인접한 숫자라면 )
                if(knight[i][j]!=0 && queN.contains(knight[i][j]) ) {
                    //System.out.println("이거 오류나용 :"+ (i+dx[dir]) +","+(j+dy[dir]) +"dir:"+dir);

                    int nx = i+dx[dir];
                    int ny = j+dy[dir];

                    knight2[nx][ny] = knight[i][j] ;	//새 배열에 그전값 복사 ( 이동 )

                    visit[i][j] = true;
                    visit[nx][ny] = true;
                }

            }
        }

        for(int i=0;i<L;i++) {
            for(int j=0; j<L;j++) {
                if( visit[i][j]) {
                    knight[i][j] = knight2[i][j];
                }


            }
        }


    }
    private static boolean cango(int n, int dir){
        //n번째 기사가 dir 방향으로 1칸 이동 가능한지 확인
        Queue<int[]> que = new LinkedList<>();


        for(int i=0; i<L;i++){
            for(int j=0; j<L;j++){
                if(knight[i][j]==n) {
                    que.offer(new int[]{i,j}); //옮길곳 위치 저장
                    queN.offer(knight[i][j]); //병사 번호 저장
                }
            }
        }

        while(!que.isEmpty()){
            int arr[] = que.poll();
            //queN.poll();
            int arrx = arr[0];
            int arry = arr[1];

            //옮겨갈곳
            int nx = arrx + dx[dir];
            int ny = arry + dy[dir];

            //System.out.println("지금볼곳 : "+arrx+","+arry);
            if(!check(nx,ny)|| chess[nx][ny]==2) {
                //System.out.println("벽있어 막힘: "+(nx)+","+(ny));
                return false;
            }



            //다른 병사가 있을 경우
            if( knight[nx][ny] != 0 && (knight[arrx][arry]!=knight[nx][ny]) ){

                int val = knight[nx][ny] ; // 다른  병정 번호

                for(int i=0;i<L;i++) {
                    for(int j=0;j<L;j++) {
                        // 그병정 번호를 가진 병정 !! 다 들어갓
                        if(knight[i][j] == val) {

                            que.offer(new int[]{i,j}); //밀쳐지는 병사 위치 저장
                        }
                    }
                }

                //해당 값을 저장
                //que.offer(new int[]{nx,ny}); //밀쳐지는 병사 위치 저장
                queN.offer(knight[nx][ny]);

//                System.out.println("여기 봐야댐 사람있어용: "+nx+","+ny);
//                System.out.println("병사  "+knight[nx][ny]) ;
            }

        }

        return true;
    }
    private static boolean check(int x, int y){
        if(x<0||x>=L||y<0||y>=L) return false;
        return true;
    }
    //디버깅 함수
    private static void printMap(){
        for(int i=0;i<L;i++){
            for(int j=0;j<L;j++){
                System.out.print(knight[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static void getTotal(){

        for(int i=0;i<N;i++) {
            for(int j=0;j<Q;j++) {
                ans += dm[i][j];
            }
        }
    }
}
