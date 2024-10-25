class User:
    def __init__(self, id, name, email):
        self.id = id
        self.name = name
        self.email = email


#The in-memory system we shall use to manipulate the users
class UserManagementSystem:
    def __init__(self):
        self.users = [] #This is the user List {Acting as our database}

    def add_user(self, id, name, email):
        user = User(id, name, email)
        self.users.append(user)
        print(f"User {name} added successfully.")

    def get_user_by_id(self, id):
        for user in self.users:
            if user.id == id:
                return user
        print(f"User with id {id} not found.")
        return None

    def update_user(self, id, name=None, email=None):
        user = self.get_user_by_id(id)
        if user:
            if name:
                user.name = name
            if email:
                user.email = email
            print(f"User with id {id} updated successfully.")
        else:
            print(f"Failed to update. User with id {id} not found.")

    def delete_user(self, id):
        user = self.get_user_by_id(id)
        if user:
            self.users.remove(user)
            print(f"User with id {id} deleted successfully.")
        else:
            print(f"Failed to delete. User with id {id} not found.")

# Usage
user_system = UserManagementSystem()

# Add users
user_system.add_user(1, "John Mukasa", "john@camtech.com")
user_system.add_user(2, "Janeh Alupo", "jane@gmail.com")

#Delete a user
user_system.delete_user(5)
