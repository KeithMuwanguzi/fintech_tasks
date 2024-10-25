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
        # Check if ID already exists
        if any(user.id == id for user in self.users):
            print(f"Error: User with ID {id} already exists.")
            return

        # Check if email already exists
        if any(user.email == email for user in self.users):
            print(f"Error: User with email {email} already exists.")
            return

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
                # Check if email already exists for another user
                if any(u.email == email and u.id != id for u in self.users):
                    print(f"Error: User with email {email} already exists.")
                else:
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
def main():
    user_system = UserManagementSystem()
    print("Welcome to the User Management System")

    while True:
        print("\nPlease select an option:")
        print("1. Add user")
        print("2. Get user by ID")
        print("3. Update user")
        print("4. Delete user")
        print("5. Print all users")
        print("6. Exit")

        choice = input("Enter your choice (1-6): ")

        match choice:
            case '1':
                id = input("Enter user ID: ")
                name = input("Enter user name: ")
                email = input("Enter user email: ")
                user_system.add_user(id, name, email)
            case '2':
                id = int(input("Enter user ID to get: "))
                user = user_system.get_user_by_id(id)
                if user:
                    print(f"User found - ID: {user.id}, Name: {user.name}, Email: {user.email}")
            case '3':
                id = int(input("Enter user ID to update: "))
                name = input("Enter new name (leave blank to keep current): ")
                email = input("Enter new email (leave blank to keep current): ")
                user_system.update_user(id, name if name else None, email if email else None)
            case '4':
                id = int(input("Enter user ID to delete: "))
                user_system.delete_user(id)
            case '5':
                if len(user_system.users) != 0:
                    print("\nAll users:")
                    for user in user_system.users:
                        print(f"ID: {user.id}, Name: {user.name}, Email: {user.email}")
                else:
                    print('No users in the system yet')
            case '6':
                print("Thank you for using the User Management System. Goodbye!")
                break
            case _:
                print("Invalid choice. Please try again.")


if __name__ == '__main__':
    main()
