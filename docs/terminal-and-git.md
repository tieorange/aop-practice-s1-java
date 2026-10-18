# Практичне заняття № 1 — термінал і Git

- **Студент:** Ковальчук Андрій Олегович
- **Група:** ЧСБ24F301ДОФ26
- **Дисципліна:** Алгоритмізація та основи програмування
- **Дата виконання:** 18 жовтня 2026 року

Робота виконана за матеріалами `aop-practice-devops-1.docx` та `aop-practice-git-1.docx`. Усі фрагменти нижче — фактичний вивід команд із macOS. Закриті ключі, паролі й токени до репозиторію не додавалися.

## Java-код і дискусія

Власний публічний репозиторій на основі шаблону курсу: [tieorange/aop-practice-s1-java](https://github.com/tieorange/aop-practice-s1-java). У ньому реалізовано й перевірено задачі LeetCode 2413 та 1523, додано unit-тести, посилання на Accepted submissions і відповіді на питання відкритої дискусії.

## 1. Термінал і файлова система

### Оболонка

```text
$ echo $SHELL
/bin/zsh
$ ps -p $$ -o comm=
/bin/zsh
$ which zsh
/bin/zsh
$ which bash
/bin/bash
```

Профілем і поточним процесом використовується `zsh`.

### Поточне розташування та приховані файли

```text
$ cd /Users/anduser
$ pwd
/Users/anduser
$ ls | wc -l
75
$ ls -la | wc -l
221
```

`ls -la` показує більше елементів, бо включає приховані файли й теки, назви яких починаються з крапки, а також записи `.` і `..`. Тут підраховано рядки виводу, включно з рядком `total` для `ls -la`.

### Навігація шляхами

Створено дерево `/Users/anduser/dev/terminal-lab/src/main`. Перевірка переходів:

```text
$ cd /Users/anduser/dev/terminal-lab && pwd
/Users/anduser/dev/terminal-lab
$ cd src/main && pwd
/Users/anduser/dev/terminal-lab/src/main
$ cd ../.. && pwd
/Users/anduser/dev/terminal-lab
$ cd /Users/anduser && pwd
/Users/anduser
```

### Відносні та абсолютні шляхи

```text
$ cd /Users/anduser/dev/terminal-lab
$ ls src/main
$ cd src
$ ls src/main
ls: src/main: No such file or directory
$ ls main
$ ls /Users/anduser/dev/terminal-lab/src/main
```

Команда `ls src/main` працює з кореня `terminal-lab`, але після переходу в `src` шукає неіснуючий шлях `src/src/main`. Відносний шлях `main` працює саме з теки `src`, а абсолютний шлях не залежить від поточної теки.

### GUI та повторювані дії

У Finder створено теку `gui-created-older` у `terminal-lab`; термінал бачить її як звичайну теку. Команда нижче створила 16 тек лекцій:

```text
$ mkdir -p ~/dev/terminal-lab/lecture-{01..16}
$ find ~/dev/terminal-lab -maxdepth 1 -type d -name 'lecture-*' | wc -l
16
```

### Відомості про систему

```text
$ uname -s
Darwin
$ uname -a
Darwin Mac 25.6.0 Darwin Kernel Version 25.6.0: Fri Jul 31 19:18:48 PDT 2026; root:xnu-12377.161.14~5/RELEASE_ARM64_T6020 arm64
$ df -h ~
/dev/disk3s5   460Gi   418Gi    16Gi    97%   /System/Volumes/Data
$ du -sh ~/dev/terminal-lab
4.0K    /Users/anduser/dev/terminal-lab
```

## 2. Git

### Версія та глобальний автор

```text
$ git --version
git version 2.50.1 (Apple Git-155)

$ git config --global --list --show-origin | grep 'user\.'
file:/Users/anduser/.gitconfig  user.email=tieorange@gmail.com
file:/Users/anduser/.gitconfig  user.name=Andrii Kovalchuk
```

Налаштування автора зберігаються у звичайному текстовому файлі `~/.gitconfig` і застосовуються глобально.

### Identity комітів

У тимчасовому локальному репозиторії `/tmp/aop-practice-1-identity-test` створено два коміти. Другому репозиторійно задано іншу пошту:

```text
$ git log --format='%h %an <%ae> %s'   # після першого коміту
a4f7419 Andrii Kovalchuk <tieorange@gmail.com> first commit

$ git log --format='%h %an <%ae> %s'   # після другого коміту
d7c09eb Andrii Kovalchuk <someone-else@example.com> second commit
a4f7419 Andrii Kovalchuk <tieorange@gmail.com> first commit
```

Перший коміт зберігає початкову пошту, навіть після зміни локального налаштування. Отже, ім'я та email входять до даних кожного коміту, а `user.email` у репозиторії перекриває глобальне значення лише для наступних комітів.

### Історія репозиторію курсу

У завданні курсу вказано шаблон [`djnzx/java-template`](https://github.com/djnzx/java-template). Його клоновано до тимчасової теки `/tmp/aop-practice-1-java-template` і переглянуто історію:

```text
$ git clone https://github.com/djnzx/java-template.git /tmp/aop-practice-1-java-template
$ cd /tmp/aop-practice-1-java-template
$ git log --oneline -5
dc73f22 homework 1-6 placeholders
148d2b4 java 25 + dependencies
d53afe0 -- initial
```

У репозиторії наразі три коміти, тому `git log --oneline -5` вивів усі доступні. Перші два повідомлення пояснюють зміст змін, тоді як `-- initial` не дає майбутньому читачеві корисного опису.

### Письмові відповіді

1. `git log` розв’язує задачу «хто змінив» (а зміст повідомлення коміту допомагає зрозуміти причину зміни).
2. `git diff` розв’язує задачу «що саме змінилося», показуючи відмінності між станами файлів.
3. Задача поєднання паралельних змін не має повного розв’язку до заняття 10, де розглядаються злиття та конфлікти.

## Висновок

Термінал дає відтворювані дії та точне керування шляхами, а Git зберігає історію станів проєкту й автора кожного коміту. Історію шаблону курсу перевірено локальним клонуванням.
