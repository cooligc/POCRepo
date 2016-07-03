#Use root user to execute the scripts


#Install openSSH Server if not there
apt-get install libssl0.9.8 ssh openssh-server gcc make

#Download the mysecureshell and configure it
wget http://mysecureshell.free.fr/repository/index.php/source/mysecureshell_1.31.tar.gz
tar xvfvz mysecureshell_1.31.tar.gz
cd mysecureshell_1.31
./configure
make
sudo ./install.sh en

#Add a user group
groupadd sftp

#Create user 
useradd -m -s /usr/bin/MySecureShell -g sftp bob

#Set the password
passwd bob

#Restart SSH 
service ssh restart

#Restart sshd 
service sshd restart
