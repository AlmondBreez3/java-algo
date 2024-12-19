package java_algo.other;

import java.util.*;

public class 광물캐기 {

    class Solution {
        public class Pair{
            int cate;
            int stress;
            int count;
            int c;
            public Pair(int cate, int stress,int count,int c) {
                this.cate = cate;
                this.stress = stress;
                this.count = count;
                this.c = c;
            }
        }
        public int solution(int[] picks, String[] minerals) {
            // dia - 3 metal - 2 rock - 1
            // 돌은 무엇으로 캐도 상관이 없음
            PriorityQueue<Pair> rock = new PriorityQueue<>(Comparator.comparingInt((Pair o) -> -o.c));
            PriorityQueue<Pair> metal = new PriorityQueue<>(
                    Comparator.comparingInt((Pair o) -> -o.c).thenComparingInt(o -> o.stress)
            );
            PriorityQueue<Pair> diamond = new PriorityQueue<>(
                    Comparator.comparingInt((Pair o) -> -o.c).thenComparingInt(o -> o.stress)
            );

            for (int i = 0; i < picks.length; i++) {
                if (i == 0) {
                    diamond.offer(new Pair(i,1,picks[i],0));
                    metal.offer(new Pair(i,1,picks[i],0));
                    rock.offer(new Pair(i,1,picks[i],0));
                } else if (i == 1) {
                    diamond.offer(new Pair(i,5,picks[i],0));
                    metal.offer(new Pair(i,1,picks[i],0));
                    rock.offer(new Pair(i,1,picks[i],0));
                } else {
                    diamond.offer(new Pair(i,25,picks[i],0));
                    metal.offer(new Pair(i,5,picks[i],0));
                    rock.offer(new Pair(i,1,picks[i],0));
                }

            }


            int stress = 0;
            for (int i = 0; i < minerals.length; i++) {
                if (minerals[i].equals("diamond")){

                    if (diamond.isEmpty()) break;
                    Pair curD = diamond.peek();

                    for (Pair a :diamond) {
                        System.out.print(a.cate+" test" + " " + a.count + " "+a.c+" ");
                        System.out.println();
                    }

                    if (curD.count == 0) {
                        diamond.poll();
                        curD = diamond.peek();
                    }
                    if (curD.count > 0) {
                        stress += curD.stress;
                    }
                    int curC = curD.c;
                    if (curC == 5) {
                        diamond.poll();
                        diamond.offer(new Pair(curD.cate,curD.stress,curD.count-1,0));
                    } else {
                        diamond.poll();
                        diamond.offer(new Pair(curD.cate,curD.stress,curD.count,curD.c + 1));

                        if (metal.peek().cate == curD.cate) {
                            metal.poll();
                            metal.offer(new Pair(curD.cate,curD.stress,curD.count,curD.c + 1));
                        }
                        if (rock.peek().cate == curD.cate) {
                            rock.poll();
                            rock.offer(new Pair(curD.cate,curD.stress,curD.count,curD.c + 1));
                        }
                    }

                    System.out.print(i+ " "+ minerals[i]+" "+ curD.cate+" "+curD.stress);
                    System.out.println();
                } else if (minerals[i].equals("iron")){
                    if (metal.isEmpty()) break;

                    Pair curI = metal.peek();



                    for (Pair a : metal) {
                        System.out.print(a.cate+" test" + " " + a.count + " "+a.c+" ");
                        System.out.println();
                    }


                    System.out.print(i+ " "+" "+ curI.cate+" "+curI.stress + curI.count);
                    System.out.println();
                    if (curI.count == 0) {
                        metal.poll();
                        curI = metal.peek();
                    }
                    if (curI.count > 0) {
                        stress += curI.stress;
                    }
                    int curC = curI.c;
                    if (curC == 5) {
                        metal.poll();
                        metal.offer(new Pair(curI.cate,curI.stress,curI.count-1,0));
                    } else {
                        metal.poll();
                        metal.offer(new Pair(curI.cate,curI.stress,curI.count,curI.c+1));

                        if (diamond.peek().cate == curI.cate) {
                            diamond.poll();
                            diamond.offer(new Pair(curI.cate,curI.stress,curI.count,curI.c+1));
                        }

                        if (rock.peek().cate == curI.cate) {
                            rock.poll();
                            rock.offer(new Pair(curI.cate,curI.stress,curI.count,curI.c+1));
                        }
                    }


                } else {
                    if (rock.isEmpty()) break;
                    Pair curR = rock.peek();
                    System.out.print(i+ " "+ minerals[i]+" "+ curR.cate + " "+ curR.stress);
                    System.out.println();
                    if (curR.count == 0) {
                        rock.poll();
                        curR = rock.peek();
                    }
                    if (curR.count>0) {
                        stress += curR.stress;
                    }
                    int curC = curR.c;
                    if (curC == 5) {
                        rock.poll();
                        rock.offer(new Pair(curR.cate,curR.stress, curR.count -1,0));
                    } else {
                        rock.poll();
                        rock.offer(new Pair(curR.cate,curR.stress, curR.count,curR.c+1));

                        if (diamond.peek().cate == curR.cate) {
                            diamond.poll();
                            diamond.offer(new Pair(curR.cate,curR.stress, curR.count,curR.c+1));

                        }
                        if (metal.peek().cate == curR.cate) {
                            metal.poll();
                            metal.offer(new Pair(curR.cate,curR.stress, curR.count,curR.c+1));
                        }

                    }

                }
            }

            // System.out.println(rock.poll().cate);
            // System.out.println(metal.poll().cate);
            // System.out.println(diamond.poll().cate);



            int answer = stress;
            return answer;
        }
    }

}
