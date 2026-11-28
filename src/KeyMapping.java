
public class KeyMapping {

	public static void main(String[] args)
	{
		while (!enemy.checkDead())
		{
	    	// 파티원 수만큼 블록 안의 행동을 반복
	    	for (GameCharacter p : party)
	    	{
	    		// 파티원이 살아있다면 진행시켜
	    		// 턴 안내, 입력한 값에 따라 행동이 바뀐다.
	    		if (p.checkDead()) continue;
	    		System.out.println("\n" + p.getName() + "의 턴입니다.");
	    		System.out.println("z: 일반 공격 | x: 스킬1 | c: 스킬2 | ※ c는 미요만 사용할 수 있습니다.");
	    		char ch = sc.next().charAt(0);
	    		
	    		// 입력값이 z라면 일반 공격을 시전
	    		if (ch == 'z')
	    		{
	    			p.attack(enemy);
	    		}
	    		
	    		// 입력값이 x라면 스킬을 시전
	    		else if (ch == 'x')
	    		{
	    			// 만약 x를 입력한 객체가 사제라면
	    			if (p instanceof Priest)
	    			{
	    				// 1 2 3중에 하나를 골라서 회복을 시전
	    				// 이것도 나중에 밑에 드래곤처럼 party.size를 이용해서
	    				// 파티원이 세 명을 초과해도 그 대상에게 사용할 수 있지 않을까?
	    				// 일단은 세 명에게 하는 걸로
	    				System.out.println("회복시킬 대상을 선택하세요. | 1: 치요 | 2: 미요 | 3: 사요");
	    				int number = sc.nextInt();
	    				
	    				if (number == 1)
	    				{
	    					p.castSpell(party.get(0));
	    				}
	    				
	    				else if (number == 2)
	    				{
	    					p.castSpell(party.get(1));
	    				}
	    				
	    				else if (number == 3)
	    				{
	    					p.castSpell(party.get(2));
	    				}
	    				
	    				// 다른 값을 입력하면 스킬 무효!
	    				else
	    				{
	    					System.out.println("사요가 회복 주문을 잘못 외웠습니다...");
	    				}
	    			}
	    			
	    			// 그 외 직업은 그냥 스킬 시전
	    			else
	    			{
	    				p.castSpell(enemy);
	    			}
	    		}
	    		
	    		// 입력값이 c라면
	    		else if (ch == 'c')
	    		{
	    			// 마법사 객체만 2번째 스킬을 시전. Mage로 형변환해줘야 함
	    			if (p instanceof Mage)
	    			{
	    				((Mage) p).castIceSpell(enemy);
	    			}
	    			
	    			// 다른 직업이라면 또 스킬 무효!
	    			else
	    			{
	    				System.out.println("아직 배우지 못한 스킬입니다.");
	    			}
	    		}
	    		enemy.printStatus();
	    	}
		}
	}
}
